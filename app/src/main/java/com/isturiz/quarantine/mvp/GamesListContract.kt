package com.isturiz.quarantine.mvp

import java.lang.Exception

interface GamesListContract {

    interface View<T> : BaseContract.View<T> {
        fun setItems(items: List<T>)
        fun navigateToViewForItem(item: T)
    }

    interface Presenter<T> : BaseContract.Presenter<T> {
        fun onItemClicked(item: T)
        fun onListScrolledToEnd()
    }
}