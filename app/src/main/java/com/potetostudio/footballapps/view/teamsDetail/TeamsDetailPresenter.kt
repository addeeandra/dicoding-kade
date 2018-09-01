package com.potetostudio.footballapps.view.teamsDetail

import com.potetostudio.footballapps.data.ApiRepository
import com.potetostudio.footballapps.data.DbRepository
import com.potetostudio.footballapps.data.remote.response.TeamResponse

class TeamsDetailPresenter(private val mView: TeamsDetailView,
                           private val mApi: ApiRepository,
                           private val mDb: DbRepository) {

    private var mTeamDetail: TeamResponse.Team? = null

    suspend fun fetchTeamDetail(teamId: String) {
        mView.showLoading()

        mTeamDetail = mApi.detailTeam(teamId).await().teams?.get(0)
        mTeamDetail?.let { mView.showTeamDetail(it) }

        invalidateFavorite(teamId)

        mView.hideLoading()
    }

    fun addToFavorite() {
        mTeamDetail?.let {
            mDb.addToFavoriteTeam(it)
            invalidateFavorite(it.id)
        }
    }

    fun removeFromFavorite() {
        mTeamDetail?.let {
            mDb.removeFromFavoriteTeam(it.id)
            invalidateFavorite(it.id)
        }
    }

    private fun invalidateFavorite(teamId: String) {
        val isFavorited = mDb.isFavoriteTeamExists(teamId)
        if (isFavorited) {
            mView.showMenuAddedToFavorite()
        } else {
            mView.showMenuAddToFavorite()
        }
    }

}