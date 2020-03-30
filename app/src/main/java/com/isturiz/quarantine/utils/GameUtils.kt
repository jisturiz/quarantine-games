package com.isturiz.quarantine.utils

import androidx.fragment.app.Fragment
import com.isturiz.quarantine.api.models.DeckWords
import com.isturiz.quarantine.api.models.Equipment
import com.isturiz.quarantine.api.models.Game
import com.isturiz.quarantine.views.games.CodenamesFragment

object GameUtils {
    //TODO clean this up bigly
    fun buildFragmentForGame(game: Game, equipment: Equipment?): Fragment? {
        return when(game.name) {
            "Codenames" -> CodenamesFragment.newInstance(equipment = equipment as DeckWords)
            else -> null
        }
    }
}