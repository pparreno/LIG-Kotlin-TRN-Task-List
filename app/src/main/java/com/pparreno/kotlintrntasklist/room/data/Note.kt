package com.pparreno.kotlintrntasklist.room.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity
data class Note(
    var dateCreated: Date,
    var dateUpdated: Date,
    var dateDeleted: Date?,
    var title: String,
    var content: String,
    var isImportant: Boolean,
    var isFavorite: Boolean
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
