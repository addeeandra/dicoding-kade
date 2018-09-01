package com.potetostudio.footballapps.view.favoritesEvents

import com.potetostudio.footballapps.data.remote.response.EventResponse

interface FavoriteEventsView {

    fun showEvents(events: List<EventResponse.Event>)

    fun showLoading()

    fun hideLoading()

    fun showPlaceholder()

    fun hidePlaceholder()

}