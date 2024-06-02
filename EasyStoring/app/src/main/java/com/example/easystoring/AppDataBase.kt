//package com.example.easystoring
//
//import CupboardTypeConverter
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverter
//import androidx.room.TypeConverters
//import com.example.easystoring.logic.dao.UserDao
//
////@Database(version = 1, entities = [User::class])
//abstract class AppDataBase : RoomDatabase() {
//    abstract fun userDao(): UserDao
//
//    companion object {
//        private var instance: AppDataBase? = null
//
//        @Synchronized
//        fun getDatabase(context: Context): AppDataBase {
//            instance?.let {
//                return it
//            }
//            return Room.databaseBuilder(
//                context.applicationContext,
//                AppDataBase::class.java,
//                "app_database"
//            ).build().apply {
//                instance = this
//            }
//        }
//    }
//}