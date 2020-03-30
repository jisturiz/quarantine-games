package com.isturiz.quarantine.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isturiz.quarantine.R
import com.isturiz.quarantine.addFragment
import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.mvp.GamesListContract
import com.isturiz.quarantine.presenters.GamesListPresenter
import com.isturiz.quarantine.ui.adapters.GamesListAdapter
import kotlinx.android.synthetic.main.fragment_games_list.*
import java.lang.Exception

/**
 * A fragment representing a list of Games.
 */
class GamesListFragment() : Fragment(), GamesListContract.View<Game> {

    override var presenter: GamesListPresenter = GamesListPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_games_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewInitialized()

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    //TODO: (Isturiz) support pagination
    override fun setItems(items: List<Game>) {
        recycler_view.apply {
            adapter = GamesListAdapter(context, items, presenter)
        }
    }

    override fun navigateToViewForItem(item: Game) {
        activity?.addFragment(GameLandingFragment.newInstance(item))
    }

    override fun showError(exception: Exception) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
