package com.potetostudio.footballapps.view.teamsDetail

import com.potetostudio.footballapps.data.remote.response.TeamResponse

interface TeamsDetailView {

    fun showTeamDetail(team: TeamResponse.Team)

    fun showMenuAddToFavorite()

    fun showMenuAddedToFavorite()

    fun showLoading()

    fun hideLoading()

}