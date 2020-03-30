package com.isturiz.quarantine.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isturiz.quarantine.R
import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.mvp.GameLandingContract
import com.isturiz.quarantine.presenters.GameLandingPresenter
import com.isturiz.quarantine.views.games.PlayGameActivity
import com.isturiz.quarantine.views.games.PlayGameActivity.Companion.EXTRA_GAME
import kotlinx.android.synthetic.main.fragment_game_landing.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 * Use the [GameLandingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameLandingFragment : Fragment(), GameLandingContract.View<Game> {

    override val presenter: GameLandingPresenter = GameLandingPresenter(this)
    private lateinit var game: Game

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_game_landing, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        game = arguments?.getParcelable(ARG_GAME) ?: Game()
        presenter.onViewInitialized()

        button_play.setOnClickListener {
            presenter.onPlayGameClicked()
        }
    }
    companion object {
        const val ARG_GAME = "game"

        @JvmStatic
        fun newInstance(game: Game) =
            GameLandingFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_GAME, game)
                }
            }
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(exception: Exception) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playGame() {
        val intent = Intent(context, PlayGameActivity::class.java)
        intent.putExtra(EXTRA_GAME, game)
        startActivity(intent)
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
