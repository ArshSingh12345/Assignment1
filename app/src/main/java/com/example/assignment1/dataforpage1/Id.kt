package com.example.assignment1.dataforpage1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Id(
    val created_by_id: Int,
    val created_on: String,
    val id: Int,
    val is_selected: Boolean,
    val state_id: Int,
    val title: String,
    val type_id: Int,
    var isSelected: Boolean = false
) : Parcelable
