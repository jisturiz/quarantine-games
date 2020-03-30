package com.isturiz.quarantine.presenters

import android.util.Log
import com.google.firebase.firestore.ktx.toObject
import com.isturiz.quarantine.api.models.DeckWords
import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.api.queries.EquipmentQueries
import com.isturiz.quarantine.mvp.PlayGameContract
import com.isturiz.quarantine.utils.toEquipment

class PlayGamePresenter(override val view: PlayGameContract.View<Game>) : PlayGameContract.Presenter<Game> {

    override fun onViewInitialized() {
        view.showLoading()
        fetchEquipment()
    }

    private fun fetchEquipment() {
        view.game.equipmentReferences?.forEach { docRef ->
            EquipmentQueries().getDocumentByReference(docRef)
                .addOnSuccessListener { result ->
                    result.toEquipment()?.let {

                        //TODO: how to wait for last equipment success
                        view.equipment.add(it)
                        view.startGame()
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w("testing", "Error getting documents.", exception)
                    //view.showError(exception)
                }
        }
    }
}