package com.isturiz.quarantine.mvp

import java.lang.Exception

interface BaseContract {

    interface View<T> {
        val presenter: Presenter<T>
        fun showLoading()
        fun hideLoading()
        fun showError(exception: Exception)
    }

    interface Presenter<T> {
        val view: View<T>
        fun onViewInitialized()
    }

}