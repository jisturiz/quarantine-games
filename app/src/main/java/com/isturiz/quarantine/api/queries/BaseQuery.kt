package com.isturiz.quarantine.api.queries

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

abstract class BaseQuery<T> {
    abstract val collectionName: String

    private val fireStore = Firebase.firestore
    private fun collection() = fireStore.collection(collectionName)

    fun getAll(): Task <QuerySnapshot> = collection().get()

    fun getDocumentByReference(docRef: String): Task<DocumentSnapshot> = collection().document(docRef).get()
}

