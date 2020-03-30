package com.isturiz.quarantine.utils

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.toObject
import com.isturiz.quarantine.api.models.DeckWords
import com.isturiz.quarantine.api.models.Equipment

fun DocumentSnapshot.toEquipment(): Equipment? {
    //TODO: see if I can leverage equipment class vs using magic string
    return when(id) {
        "deckWords" -> toObject<DeckWords>()
        else -> null
    }
}
