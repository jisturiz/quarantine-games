package com.isturiz.quarantine.api.queries

import com.isturiz.quarantine.api.models.Game

class GamesQueries : BaseQuery<Game>() {
    override val collectionName = "games"
}