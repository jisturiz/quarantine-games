package com.isturiz.quarantine.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.mvp.GamesListContract
import com.isturiz.quarantine.ui.viewholders.GameViewHolder


class GamesListAdapter(
    private val context: Context,
    private val list: List<Game>,
    private val itemClickListener: GamesListContract.Presenter<Game>
) : RecyclerView.Adapter<GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GameViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game: Game = list[position]
        holder.bind(context, game, itemClickListener)
    }

    override fun getItemCount(): Int = list.size


}