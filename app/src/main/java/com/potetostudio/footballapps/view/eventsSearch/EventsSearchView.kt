package com.potetostudio.footballapps.view.eventsSearch

import com.potetostudio.footballapps.data.remote.response.EventResponse

interface EventsSearchView {

    fun showEvents(events: List<EventResponse.Event>)

    fun showLoading()

    fun hideLoading()

    fun showPlaceholder()

    fun hidePlaceholder()

}