package com.potetostudio.footballapps.view.playersDetail

import com.potetostudio.footballapps.data.remote.response.PlayerResponse

interface PlayersDetailView {

    fun showPlayerDetail(player: PlayerResponse.Player)

    fun showLoading()

    fun hideLoading()

}