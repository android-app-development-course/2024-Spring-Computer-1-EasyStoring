package com.example.easystoring.logic.model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import com.example.easystoring.Item
import com.example.easystoring.Cupboard
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.logic.network.NetworkService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody


class AppDBHelper (val context: Context, name: String, version: Int):
    SQLiteOpenHelper(context,name, null, version){

    private val createCupboard = "create table Cupboard(" +
            " id integer primary key autoincrement," +
            " userId integer, " +
            " name text, " +
            " description text)"
    private val createItem = "create table Item(" +
            " id integer primary key autoincrement," +
            " userId integer, " +
            " imageId text, " +
            " name text, " +
            " description text, " +
            " number integer, " +
            " productionDate text, " +
            " overdueDate text, " +
            " cupboardId integer)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createCupboard)
        db.execSQL(createItem)
        //Toast.makeText(context, "Create Succeeded", Toast.LENGTH_SHORT).show()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    @SuppressLint("Range")
    fun getAllFromMyTable(db: SQLiteDatabase, tableName: String, columns:Array<String>): List<Map<String, Any?>> {
        val list = mutableListOf<Map<String, Any?>>()
        val cursor: Cursor = db.query(tableName, columns,
            null, null, null, null, null)
        if (cursor.moveToFirst()) {
            do {
                val row = mutableMapOf<String, Any?>()
                for (columnName in columns) {
                    row[columnName] = cursor.getString(cursor.getColumnIndex(columnName))
                }
                list.add(row)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return list
    }

    fun rebuildTable( db: SQLiteDatabase,tableName:String){
        when(tableName){
            "Cupboard"->{
                db.execSQL("DROP TABLE IF EXISTS Cupboard")
                db.execSQL(createCupboard)
            }
            "Item"->{
                db.execSQL("DROP TABLE IF EXISTS Item")
                db.execSQL(createItem)
            }
        }
    }

    // 获取MyTable中所有行的函数
    fun getAllRowsFromMyTable(db: SQLiteDatabase, tableName:String): List<Map<String, Any?>> {
        val list = mutableListOf<Map<String, Any?>>()
        val cursor: Cursor = db.query(tableName, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val row = mutableMapOf<String, Any?>()
                for (i in 0 until cursor.getColumnCount()) {
                    row[cursor.getColumnName(i)] = cursor.getString(i) // 注意：这里为了简化，我们假设所有列都是String类型
                }
                list.add(row)
            } while (cursor.moveToNext())
        }

        cursor.close()
        return list
    }
    // 获取指定表的行数
    fun getRowCount(db: SQLiteDatabase,tableName: String): Int {
        val cursor: Cursor
        try {
            cursor = db.rawQuery("SELECT COUNT(*) FROM $tableName", null)
            if (cursor.moveToFirst()) {
                return cursor.getInt(0)
            }
            cursor.close()
        } catch (e:Exception) {
            Log.d("error",e.message!!)
        }
        // 如果没有行，返回0
        return 0
    }
    fun insertItem(db: SQLiteDatabase, Item1: Item){
        val values = ContentValues().apply {
            // 组装数据
            put("id",Item1.id)
            put("userId", Item1.userId)
            put("imageId",Item1.imageId)
            put("name",Item1.name)
            put("description",Item1.description)
            put("number", Item1.number)
            put("productionDate",Item1.productionDate)
            put("overdueDate", Item1.overdueDate)
            put("cupboardId", Item1.cupboardId)
        }
        db.insert("Item", null, values)
    }

    fun insertCupboard(db: SQLiteDatabase, cupboard: Cupboard) {
        val values = ContentValues().apply {
            // 组装数据
            put("id",cupboard.id)
            put("userId", cupboard.userId)
            put("name",cupboard.name)
            put("description",cupboard.description)
        }
        db.insert("Cupboard", null, values)
    }

    fun delItemById(db: SQLiteDatabase,id: Int){
        db.delete("Item", "id = ?", arrayOf(id.toString()))
    }
    fun delCupboardById(db: SQLiteDatabase,id: Int){
        db.delete("Cupboard", "id = ?", arrayOf(id.toString()))
    }
    fun updateItem(db: SQLiteDatabase, Item1: Item){
        val values = ContentValues().apply {
            // 组装数据
            put("id",Item1.id)
            put("userId", Item1.userId)
            put("imageId",Item1.imageId)
            put("name",Item1.name)
            put("description",Item1.description)
            put("number", Item1.number)
            put("productionDate",Item1.productionDate)
            put("overdueDate", Item1.overdueDate)
            put("cupboardId", Item1.cupboardId)
        }
        // 执行更新操作
        val updatedRows = db.update("Item", values, "id=?",
            arrayOf(Item1.id.toString()))
    }

    fun DeviceToSever(db: SQLiteDatabase){
        val allCupboards = this.getAllRowsFromMyTable(db, "Cupboard")
        val allItems = this.getAllRowsFromMyTable(db, "Item")
        for (i in allItems)
            Log.d("2333", i.toString())
        for (i in allCupboards)
            Log.d("2333", i.toString())
        // 同步Items
        try {
            runBlocking {
                var statusCode = async {
                    var temp = ""
                    runBlocking {
                        val jsonString = Gson().toJson(allItems)
                        val jsonBody =
                            jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
                        val postRequest =
                            Request.Builder().url("${NetworkService.baseURL}/syncFromDevice")
                                .header("userID", EasyStoringApplication.userID).header("tableName", "Items")
                                .post(jsonBody)
                                .build()
                        val call = NetworkService.httpClient.newCall(postRequest)
                        val response = withContext(Dispatchers.IO) {
                            call.execute()
                        }
                        Log.d("2333", response.toString())
                        response.body?.string()?.let {
                            Log.d("2333", it)
                            val response: MutableMap<*, *> = Gson().fromJson(
                                it,
                                MutableMap::class.java
                            )
                            temp = response.get("StatusCode").toString()
                            Log.d("2333", "SyncFromDevice status $temp")
                            response.get("Message")?.toString().let {
                                Log.d("2333", "SyncFromDevice message $it")
                            }
                        }
                    }
                    temp
                }.await()
                when (statusCode) {
                    "0" -> {
                        Toast.makeText(
                            EasyStoringApplication.context,
                            "云同步到服务器失败",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }

                    "1" -> {
                        // 同步Cupboards
                        delay(100)
                        runBlocking {
                            var statusCode = async {
                                var temp = ""
                                runBlocking {
                                    val jsonString = Gson().toJson(allCupboards)
                                    val jsonBody =
                                        jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
                                    val postRequest =
                                        Request.Builder()
                                            .url("${NetworkService.baseURL}/syncFromDevice")
                                            .header("userID", EasyStoringApplication.userID)
                                            .header("tableName", "Cupboards")
                                            .post(jsonBody)
                                            .build()
                                    val call = NetworkService.httpClient.newCall(postRequest)
                                    val response = withContext(Dispatchers.IO) {
                                        call.execute()
                                    }
                                    Log.d("2333", response.toString())
                                    response.body?.string()?.let {
                                        Log.d("2333", it)
                                        val response: MutableMap<*, *> = Gson().fromJson(
                                            it,
                                            MutableMap::class.java
                                        )
                                        temp = response.get("StatusCode").toString()
                                        Log.d("2333", "SyncFromDevice status $temp")
                                        response.get("Message")?.toString().let {
                                            Log.d("2333", "SyncFromDevice message $it")
                                        }
                                    }
                                }
                                temp
                            }.await()
                            when (statusCode) {
                                "0" -> {
                                    Toast.makeText(
                                        EasyStoringApplication.context,
                                        "云同步到服务器失败",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }

                                "1" -> {
                                    Toast.makeText(
                                        EasyStoringApplication.context,
                                        "云同步到服务器成功",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                else -> {
                                    Toast.makeText(
                                        EasyStoringApplication.context,
                                        "数据库错误",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                }
                            }
                        }
                    }

                    else -> {
                        Toast.makeText(
                            EasyStoringApplication.context,
                            "数据库错误",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
        } catch (e: Exception) {
            Log.d("2333error", "Exception: ${e.message}")
        }
    }

    fun SeverToDevice(db: SQLiteDatabase){
        try {
            runBlocking {
                var itemsResponse = async {
                    var res: MutableMap<*, *>? = null
                    runBlocking {
                        val getRequest =
                            Request.Builder().header("userID", EasyStoringApplication.userID)
                                .header("tableName", "Items")
                                .url("${NetworkService.baseURL}/syncFromServer")
                                .get()
                                .build()
                        val call = NetworkService.httpClient.newCall(getRequest)
                        val response = withContext(Dispatchers.IO) {
                            call.execute()
                        }
                        Log.d("2333", response.toString())
                        response.body?.string()?.let {
                            Log.d("2333", it)
                            res = Gson().fromJson(
                                it,
                                MutableMap::class.java
                            )
                        }
                    }
                    res
                }.await()
                if (itemsResponse == null) {
                    Log.d("2333", "Null response in syncFromServer")
                    Toast.makeText(
                        EasyStoringApplication.context,
                        "云同步到设备失败",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    val statusCode = itemsResponse["StatusCode"]
                    val message = itemsResponse["Message"]
                    Log.d("2333", "syncFromServer status code: $statusCode, message: $message")
                    when (statusCode) {
                        "0" -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "云同步到设备失败",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                        "1" -> {
                            // 服务器拉取的当前用户ID的所有Items
                            EasyStoringApplication.items = itemsResponse["Data"]?.let {
                                it as List<Map<String, Any>>
                            }
                            delay(100)
                            // 拉取当前用户ID的所有Cupboards
                            runBlocking {
                                var cupboardsResponse = async {
                                    var res: MutableMap<*, *>? = null
                                    runBlocking {
                                        val getRequest =
                                            Request.Builder().header("userID", EasyStoringApplication.userID)
                                                .header("tableName", "Cupboards")
                                                .url("${NetworkService.baseURL}/syncFromServer")
                                                .get()
                                                .build()
                                        val call = NetworkService.httpClient.newCall(getRequest)
                                        val response = withContext(Dispatchers.IO) {
                                            call.execute()
                                        }
                                        Log.d("2333", response.toString())
                                        response.body?.string()?.let {
                                            Log.d("2333", it)
                                            res = Gson().fromJson(
                                                it,
                                                MutableMap::class.java
                                            )
                                        }
                                    }
                                    res
                                }.await()
                                if (cupboardsResponse == null) {
                                    Log.d("2333", "Null response in syncFromServer")
                                    Toast.makeText(
                                        EasyStoringApplication.context,
                                        "云同步到设备失败",
                                        Toast.LENGTH_SHORT
                                    )
                                        .show()
                                } else {
                                    val statusCode = cupboardsResponse["StatusCode"]
                                    val message = cupboardsResponse["Message"]
                                    Log.d(
                                        "2333",
                                        "syncFromServer status code: $statusCode, message: $message"
                                    )
                                    when (statusCode) {
                                        "0" -> {
                                            Toast.makeText(
                                                EasyStoringApplication.context,
                                                "云同步到设备失败",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        }

                                        "1" -> {
                                            EasyStoringApplication.cupboards = cupboardsResponse["Data"]?.let {
                                                it as List<Map<String, Any>>
                                            }
                                            if (EasyStoringApplication.cupboards != null) {
                                                Toast.makeText(
                                                    EasyStoringApplication.context,
                                                    "云同步到设备成功",
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()
                                            } else
                                                Toast.makeText(
                                                    EasyStoringApplication.context,
                                                    "云同步到设备失败",
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()
                                        }

                                        else -> {
                                            Toast.makeText(
                                                EasyStoringApplication.context,
                                                "数据库错误",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()
                                        }
                                    }
                                }
                            }
                        }

                        else -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "数据库错误",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.d("2333error", "Exception: ${e.message}")
        }
        if (EasyStoringApplication.items != null && EasyStoringApplication.cupboards != null) {
            for (map in EasyStoringApplication.items!!) {
                val item = Item(map["userId"].toString().toInt())
                item.id = map["id"].toString().toInt()
                item.imageId = map["imageId"].toString()
                item.name = map["name"].toString()
                item.number = map["number"].toString().toInt()
                item.description = map["description"].toString()
                item.cupboardId = map["cupboardId"].toString().toInt()
                item.productionDate = map["productionDate"].toString()
                item.overdueDate = map["overdueDate"].toString()
                this.insertItem(db, item)
            }

            for (map in EasyStoringApplication.cupboards!!) {
                val cupboard = Cupboard(map["userId"].toString().toInt())
                cupboard.id = map["id"].toString().toInt()
                cupboard.name = map["name"].toString()
                cupboard.description = map["description"].toString()
                this.insertCupboard(db, cupboard)
            }

            for (i in EasyStoringApplication.items!!)
                Log.d("2333", "$i")
            for (i in EasyStoringApplication.cupboards!!)
                Log.d("2333", "$i")
        }
    }


}