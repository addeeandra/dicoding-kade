package com.potetostudio.footballapps.view.favoritesTeams

import com.potetostudio.footballapps.data.DbRepository

class FavoriteTeamsPresenter(private val mView: FavoriteTeamsView,
                             private val mDb: DbRepository) {

    suspend fun fetchFavoriteTeams() {
        mView.showLoading()

        val teams = mDb.getFavoriteTeams()
        if (teams.isNotEmpty()) {
            mView.showFavoriteTeams(teams)
            mView.hideLoading()
        } else {
            mView.showPlaceholder()
        }
    }

}