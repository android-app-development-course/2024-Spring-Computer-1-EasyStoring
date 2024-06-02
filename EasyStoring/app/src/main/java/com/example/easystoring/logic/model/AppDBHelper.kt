package com.example.easystoring.logic.model

import android.content.Context
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
            " description integer)"
    private val createItem = "create table Item(" +
            " id integer primary key autoincrement," +
            " userId integer, " +
            " imageId integer, " +
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

}