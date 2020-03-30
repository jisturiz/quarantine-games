package com.isturiz.quarantine.presenters

import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.mvp.GameLandingContract

class GameLandingPresenter(override val view: GameLandingContract.View<Game>): GameLandingContract.Presenter<Game> {

    override fun onViewInitialized() {

    }

    override fun onPlayGameClicked() {
        //TODO: fetch equipment
        view.playGame()
    }

}