package com.isturiz.quarantine.mvp

import com.isturiz.quarantine.api.models.DeckWords

interface CodenamesContract {

    interface View {
        val presenter: Presenter
        var equipment: DeckWords
        fun newGame(cards: List<String>)
    }

    interface Presenter {
        val view: View
        fun onViewInitialized()
    }
}