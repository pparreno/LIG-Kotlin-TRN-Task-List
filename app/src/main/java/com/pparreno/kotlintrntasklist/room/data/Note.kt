package com.pparreno.kotlintrntasklist.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Note(
    var dateCreated: Date,
    var dateUpdated: Date,
    var dateDeleted: Date?,
    var title: String,
    var content: String,
    var isImportant: Boolean,
    var isFavorite: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
