package com.potetostudio.footballapps.data

import com.potetostudio.footballapps.data.remote.response.EventResponse
import com.potetostudio.footballapps.data.remote.response.TeamResponse

interface DbRepository {

    fun getFavoriteEvents(): List<EventResponse.Event>
    fun addToFavoriteEvent(event: EventResponse.Event)
    fun removeFromFavoriteEvent(eventId: String)
    fun isFavoriteEventExists(eventId: String): Boolean

    fun getFavoriteTeams(): List<TeamResponse.Team>
    fun addToFavoriteTeam(team: TeamResponse.Team)
    fun removeFromFavoriteTeam(teamId: String)
    fun isFavoriteTeamExists(teamId: String): Boolean

}