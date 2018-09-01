package com.potetostudio.footballapps.view.teamsSearch

import com.potetostudio.footballapps.data.remote.response.TeamResponse

interface TeamsSearchView {

    fun showTeams(teams: List<TeamResponse.Team>)

    fun showLoading()

    fun hideLoading()

    fun showPlaceholder()

    fun hidePlaceholder()

}