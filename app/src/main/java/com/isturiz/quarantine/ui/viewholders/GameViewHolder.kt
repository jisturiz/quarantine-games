package com.isturiz.quarantine.ui.viewholders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.isturiz.quarantine.R
import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.mvp.GamesListContract

class GameViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_game, parent, false)) {
    private var nameTextView: TextView? = null
    private var playersTextView: TextView? = null

    init {
        nameTextView = itemView.findViewById(R.id.name)
        playersTextView = itemView.findViewById(R.id.players)
    }

    fun bind(context: Context, game: Game, listener: GamesListContract.Presenter<Game>) {
        nameTextView?.text = game.name
        bindPlayerCount(context, game)
        itemView.setOnClickListener {
            listener.onItemClicked(game)
        }
    }

    private fun bindPlayerCount(context: Context, game: Game) {
        val text = if(game.maxPlayers == null) {
            context.getString(R.string.game_player_count_no_max, game.minPlayers)
        } else {
            context.getString(R.string.game_player_count_range, game.minPlayers, game.minPlayers)
        }

        playersTextView?.text = text
    }
}