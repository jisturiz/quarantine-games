package com.isturiz.quarantine.presenters

import android.util.Log
import com.google.firebase.firestore.ktx.toObjects
import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.api.queries.GamesQueries
import com.isturiz.quarantine.mvp.GamesListContract


class GamesListPresenter(override val view: GamesListContract.View<Game>) : GamesListContract.Presenter<Game> {

    override fun onViewInitialized() {
        view.showLoading()

        GamesQueries().getAll()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("testing", "${document.id} => ${document.data}")
                }

                view.setItems(result.toObjects())
                view.hideLoading()
            }
            .addOnFailureListener { exception ->
                Log.w("testing", "Error getting documents.", exception)
                view.showError(exception)
            }
    }

    override fun onItemClicked(item: Game) {
        view.navigateToViewForItem(item)
    }

    override fun onListScrolledToEnd() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}