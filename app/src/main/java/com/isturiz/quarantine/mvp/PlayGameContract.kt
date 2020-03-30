package com.isturiz.quarantine.mvp

import com.isturiz.quarantine.api.models.DeckWords
import com.isturiz.quarantine.api.models.Equipment
import com.isturiz.quarantine.api.models.Game

interface PlayGameContract {

    interface View<T> : BaseContract.View<T> {
        var game: Game
        val equipment: MutableList<Equipment>
        fun startGame()
    }

    interface Presenter<T> : BaseContract.Presenter<T> {

    }

}