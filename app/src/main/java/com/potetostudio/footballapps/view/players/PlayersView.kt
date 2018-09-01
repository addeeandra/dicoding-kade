package com.potetostudio.footballapps.view.players

import com.potetostudio.footballapps.data.remote.response.PlayerResponse

interface PlayersView {

    fun showPlayers(players: List<PlayerResponse.Player>)

    fun showLoading()

    fun hideLoading()

    fun showPlaceholder()

    fun hidePlaceholder()

}