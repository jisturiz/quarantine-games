package com.isturiz.quarantine.presenters

import com.isturiz.quarantine.mvp.CodenamesContract

class CodenamesPresenter(override val view: CodenamesContract.View) : CodenamesContract.Presenter {

    override fun onViewInitialized() {
        view.newGame(drawRandomCards())
    }

    private fun drawRandomCards(): List<String> {
        return view.equipment.cards?.shuffled()?.subList(0, 24) ?: emptyList()
    }
}