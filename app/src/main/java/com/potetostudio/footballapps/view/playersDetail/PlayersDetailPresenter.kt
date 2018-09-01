package com.potetostudio.footballapps.view.playersDetail

import com.potetostudio.footballapps.data.ApiRepository

class PlayersDetailPresenter(private val mView: PlayersDetailView,
                             private val mApi: ApiRepository) {

    suspend fun fetchPlayerDetail(playerId: String) {
        mView.showLoading()

        val player = mApi.detailPlayer(playerId).await().playersDetail?.get(0)
        player?.let { mView.showPlayerDetail(it) }

        mView.hideLoading()
    }

}