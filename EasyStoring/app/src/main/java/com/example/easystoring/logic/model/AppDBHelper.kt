package com.example.easystoring.logic.model

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class AppDBHelper (val context: Context, name: String, version: Int):
    SQLiteOpenHelper(context,name, null, version){

    private val createUser = "create table User(" +
            " id integer primary key autoincrement," +
            " username text, " +
            " password text, " +
            " firstName text, "+
            " lastName text," +
            " age integer)"
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
        db.execSQL(createUser)
        db.execSQL(createCupboard)
        db.execSQL(createItem)
        Toast.makeText(context, "Create Succeeded", Toast.LENGTH_SHORT).show()
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
            "User"->{
                db.execSQL("DROP TABLE IF EXISTS User")
                db.execSQL(createUser)
            }
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

}