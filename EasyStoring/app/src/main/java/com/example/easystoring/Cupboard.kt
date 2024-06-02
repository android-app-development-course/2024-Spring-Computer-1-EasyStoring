package com.example.easystoring

class Cupboard {
    var id: Long = 0
    var items = mutableListOf<Item>()
    var name:String = "Default name"
    var description:String = "Default description"
}