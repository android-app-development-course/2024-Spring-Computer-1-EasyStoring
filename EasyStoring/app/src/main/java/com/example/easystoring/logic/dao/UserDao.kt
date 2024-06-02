package com.example.easystoring.logic.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.easystoring.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User):Long

    @Update
    fun updateUser(newUser: User)

    @Query("select * from User")
    fun loadAllUsers():List<User>

    @Query("select * from User where age > :age")
    fun loadUserOlderThan(age:Int):List<User>

    @Delete
    fun deleteUser(user:User)

    @Query("delete from User where lastName = :lastName")
    fun deleteUserByLastName(lastName:String):Int
}