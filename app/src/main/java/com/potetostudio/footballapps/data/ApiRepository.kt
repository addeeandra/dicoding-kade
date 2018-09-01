package com.potetostudio.footballapps.data

import com.potetostudio.footballapps.data.remote.response.EventResponse
import com.potetostudio.footballapps.data.remote.response.LeagueResponse
import com.potetostudio.footballapps.data.remote.response.PlayerResponse
import com.potetostudio.footballapps.data.remote.response.TeamResponse
import kotlinx.coroutines.experimental.Deferred

interface ApiRepository {

    fun leagues(type: String = "soccer"): Deferred<LeagueResponse>

    fun pastEvents(leagueId: String): Deferred<EventResponse>
    fun nextEvents(leagueId: String): Deferred<EventResponse>
    fun searchEvents(keywords: String): Deferred<EventResponse>
    fun detailEvent(eventId: String): Deferred<EventResponse>

    fun teams(leagueName: String): Deferred<TeamResponse>
    fun searchTeams(keywords: String): Deferred<TeamResponse>
    fun detailTeam(teamId: String): Deferred<TeamResponse>

    fun players(teamId: String): Deferred<PlayerResponse>
    fun detailPlayer(playerId: String): Deferred<PlayerResponse>

}