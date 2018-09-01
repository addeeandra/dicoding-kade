package com.potetostudio.footballapps.view.teams

import com.potetostudio.footballapps.data.remote.response.LeagueResponse
import com.potetostudio.footballapps.data.remote.response.TeamResponse

interface TeamsView {

    fun showLeagues(leagues: List<LeagueResponse.League>)

    fun showTeams(teams: List<TeamResponse.Team>)

    fun showLoading()

    fun hideLoading()

    fun showPlaceholder()

    fun hidePlaceholder()

}