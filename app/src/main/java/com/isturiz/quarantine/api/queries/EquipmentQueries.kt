package com.isturiz.quarantine.api.queries

import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.toObjects
import com.isturiz.quarantine.api.models.Game

class EquipmentQueries : BaseQuery<Game>() {
    override val collectionName = "equipment"
}