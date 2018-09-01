package com.potetostudio.footballapps.view.eventsDetail

import com.potetostudio.footballapps.data.ApiRepository
import com.potetostudio.footballapps.data.DbRepository
import com.potetostudio.footballapps.data.remote.response.EventResponse
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.coroutines.experimental.bg
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class EventsDetailPresenterTest {

    private val EVENT_ID = "1234"

    private lateinit var mPresenter: EventsDetailPresenter

    @Mock
    private lateinit var mView: EventsDetailView

    @Mock
    private lateinit var mApi: ApiRepository

    @Mock
    private lateinit var mDb: DbRepository


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = EventsDetailPresenter(mView, mApi, mDb)
    }

    @Test
    fun testEmpty_ShouldNot_ShowEventDetail() {
        launch (Unconfined) {
            `when`(mApi.detailEvent(EVENT_ID)).thenReturn(bg { EventResponse(listOf(), listOf()) })

            mPresenter.fetchEventDetail(EVENT_ID)

            verify(mView).hideLoading()
        }
    }

    @Test
    fun testNotEmpty_Should_ShowEventDetail() {
        launch (Unconfined) {
            val event = EventResponse.Event("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
            `when`(mApi.detailEvent(EVENT_ID)).thenReturn(bg { EventResponse(listOf(event), listOf(event)) })

            mPresenter.fetchEventDetail(EVENT_ID)

            verify(mView).showEventDetail(event)
            verify(mView).hideLoading()
        }
    }

}