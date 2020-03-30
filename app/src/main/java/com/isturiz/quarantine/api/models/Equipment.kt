package com.isturiz.quarantine.api.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class Equipment

@Parcelize
data class DeckWords(
    val cards: List<String>? = null
) : Equipment(), Parcelable

