package com.example.easystoring

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(var username: String, var password: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var firstName: String = "default"
    var lastName: String = "Default last name"
    var age: Int = 1
}