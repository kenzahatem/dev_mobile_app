package com.devmobile.campusv2


// déclarer une classe Event

data class Event(
    val id: Int,
    val title: String,
    val category: String,
    val location: String?,
    val capacity: Int ,
    val description: String
)
