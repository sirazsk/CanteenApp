package com.example.canteena

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class User(
    var email: String? = "",
    var orders : HashMap<String, Int> = HashMap<String, Int> ()
)