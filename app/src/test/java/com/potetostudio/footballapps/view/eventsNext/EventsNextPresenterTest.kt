package com.potetostudio.footballapps.view.eventsNext

import com.potetostudio.footballapps.data.ApiRepository
import com.potetostudio.footballapps.data.remote.response.EventResponse
import com.potetostudio.footballapps.data.remote.response.LeagueResponse
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.coroutines.experimental.bg
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class EventsNextPresenterTest {

    private val LEAGUE_TYPE = "Soccer"
    private val LEAGUE_ID = "1234"

    private lateinit var mPresenter: EventsNextPresenter

    @Mock
    private lateinit var mView: EventsNextView

    @Mock
    private lateinit var mApi: ApiRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = EventsNextPresenter(mView, mApi)
    }

    @Test
    fun testEmptyLeagues_shouldNot_showLeagues() {
        launch(Unconfined) {
            `when`(mApi.leagues(LEAGUE_TYPE)).thenReturn(bg { LeagueResponse(listOf()) })

            mPresenter.fetchLeagues()

            verify(mView).showPlaceholder()
        }
    }

    @Test
    fun testAvailableLeagues_should_showLeagues() {
        launch(Unconfined) {
            val leagues = listOf(LeagueResponse.League("", ""))
            `when`(mApi.leagues(LEAGUE_TYPE)).thenReturn(bg { LeagueResponse(leagues) })

            mPresenter.fetchLeagues()

            verify(mView).showLeagues(leagues)
            verify(mView).hideLoading()
        }
    }

    @Test
    fun testEmptyEvents_shouldNot_showEvents() {
        launch(Unconfined) {
            `when`(mApi.nextEvents(LEAGUE_ID)).thenReturn(bg { EventResponse(listOf(), listOf()) })

            mPresenter.fetchEvents(LEAGUE_ID)

            verify(mView).showPlaceholder()
        }
    }

    @Test
    fun testAvailableEvents_should_showEvents() {
        launch(Unconfined) {
            val events = listOf(EventResponse.Event("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""))
            `when`(mApi.nextEvents(LEAGUE_ID)).thenReturn(bg { EventResponse(events, events) })

            mPresenter.fetchEvents(LEAGUE_ID)

            verify(mView).showEvents(events)
            verify(mView).hideLoading()
        }
    }

}