package com.isturiz.quarantine.api.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Game(
    val name: String? = null,
    val minPlayers: Int? = null,
    val maxPlayers: Int? = null,
    val equipmentReferences: List<String>? = null
) : Parcelable