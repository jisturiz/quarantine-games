package com.isturiz.quarantine.mvp

interface GameLandingContract {
    interface View<T> : BaseContract.View<T>{
        fun playGame()
    }

    interface Presenter<T> : BaseContract.Presenter<T> {
        fun onPlayGameClicked()
    }
}