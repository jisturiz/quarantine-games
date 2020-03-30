package com.isturiz.quarantine.views.games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isturiz.quarantine.R
import com.isturiz.quarantine.addFragment
import com.isturiz.quarantine.api.models.Equipment
import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.mvp.PlayGameContract
import com.isturiz.quarantine.presenters.PlayGamePresenter
import com.isturiz.quarantine.utils.GameUtils
import java.lang.Exception

class PlayGameActivity : AppCompatActivity(), PlayGameContract.View<Game> {

    override val presenter: PlayGameContract.Presenter<Game> = PlayGamePresenter(this)
    override lateinit var game: Game
    override val equipment: MutableList<Equipment> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_game)

        // The game has to be initialized before anything else can happen
        // TODO: Figure out how to idiot proof this
        game = intent.getParcelableExtra(EXTRA_GAME) ?: Game()

        presenter.onViewInitialized()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(exception: Exception) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        const val EXTRA_GAME = "game"
    }

    override fun startGame() {
        GameUtils.buildFragmentForGame(game, equipment = equipment.firstOrNull())?.let {
            addFragment(it)
        }
    }
}
