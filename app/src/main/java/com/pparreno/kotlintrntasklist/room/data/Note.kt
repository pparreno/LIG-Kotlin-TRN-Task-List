package com.pparreno.kotlintrntasklist.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey var id: Int,
    var dateCreated: Long,
    var dateUpdated: Long,
    var dateDeleted: Long,
    var title: String,
    var content: String
)
