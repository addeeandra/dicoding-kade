package com.potetostudio.footballapps.view.favoritesTeams

import com.potetostudio.footballapps.data.remote.response.TeamResponse

interface FavoriteTeamsView {

    fun showFavoriteTeams(teams: List<TeamResponse.Team>)

    fun showLoading()

    fun hideLoading()

    fun showPlaceholder()

    fun hidePlaceholder()

}