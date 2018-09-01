package com.potetostudio.footballapps.view.teamsSearch

import com.potetostudio.footballapps.data.ApiRepository
import com.potetostudio.footballapps.data.remote.response.TeamResponse
import kotlinx.coroutines.experimental.Deferred

class TeamsSearchPresenter(private val mView: TeamsSearchView,
                           private val mApi: ApiRepository) {

    private var mDeferredSearch: Deferred<TeamResponse>? = null

    suspend fun fetchSearchTeams(keywords: String) {
        if (keywords.isBlank()) return

        mView.showLoading()

        mDeferredSearch?.cancel(IllegalStateException())
        mDeferredSearch = mApi.searchTeams(keywords)

        try {
            val teams = mDeferredSearch?.await()?.teams

            if (teams != null && teams.isNotEmpty()) {
                mView.showTeams(teams)
                mView.hideLoading()
            } else {
                mView.showPlaceholder()
            }
        } catch (e: IllegalStateException) { }
    }

}