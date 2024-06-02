package com.example.easystoring

import CupboardTypeConverter
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
//@TypeConverters(CupboardTypeConverter::class)
data class User(var username: String, var password: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var firstName: String = "default"
    var lastName: String = "Default last name"
    var age: Int = 1
}