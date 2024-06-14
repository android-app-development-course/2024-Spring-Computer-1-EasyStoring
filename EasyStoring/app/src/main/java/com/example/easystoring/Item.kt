package com.example.easystoring

class Item(var userId:Int) {
    var id: Int = 0
    var imageId: String = ""
    var name: String = "Default name"
    var description: String = "Default description"
    var number: Int = 1
    var productionDate: String = "2024-01-01"
    var overdueDate: String = "2025-01-01"
    var cupboardId: Int = -1
}