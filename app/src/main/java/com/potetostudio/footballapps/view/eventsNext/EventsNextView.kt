package com.potetostudio.footballapps.view.eventsNext

import com.potetostudio.footballapps.data.remote.response.EventResponse
import com.potetostudio.footballapps.data.remote.response.LeagueResponse

interface EventsNextView {

    fun showEvents(events: List<EventResponse.Event>)

    fun showLeagues(leagues: List<LeagueResponse.League>)

    fun showLoading()

    fun hideLoading()

    fun showPlaceholder()

    fun hidePlaceholder()

}