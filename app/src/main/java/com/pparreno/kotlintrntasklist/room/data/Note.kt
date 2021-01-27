package com.pparreno.kotlintrntasklist.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    var dateCreated: Long,
    var dateUpdated: Long,
    var dateDeleted: Long?,
    var title: String,
    var content: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
