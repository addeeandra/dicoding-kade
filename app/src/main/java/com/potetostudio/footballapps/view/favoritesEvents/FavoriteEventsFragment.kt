package com.potetostudio.footballapps.view.favoritesEvents

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.potetostudio.footballapps.R
import com.potetostudio.footballapps.adapter.events.EventsAdapter
import com.potetostudio.footballapps.data.db.AnkoDb
import com.potetostudio.footballapps.data.remote.response.EventResponse
import com.potetostudio.footballapps.util.openEventsDetail
import kotlinx.android.synthetic.main.layout_base_lists.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch

class FavoriteEventsFragment : Fragment(), FavoriteEventsView {

    private val mDb by lazy { AnkoDb(context!!) }
    private val mPresenter by lazy { FavoriteEventsPresenter(this, mDb) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_base_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        launch(UI) { mPresenter.fetchFavoriteEvents() }
    }

    override fun showEvents(events: List<EventResponse.Event>) {
        rv_data?.let {
            with(rv_data) {
                layoutManager = LinearLayoutManager(context)
                adapter = EventsAdapter(events) { event ->
                    activity?.openEventsDetail(event.id)
                }
            }
        }
    }

    override fun showLoading() {
        rv_data?.visibility = View.GONE
        clp_data?.show()
        hidePlaceholder()
    }

    override fun hideLoading() {
        rv_data?.visibility = View.VISIBLE
        clp_data?.hide()
        hidePlaceholder()
    }

    override fun showPlaceholder() {
        rv_data?.visibility = View.GONE
        clp_data?.hide()
        ph_data?.visibility = View.VISIBLE
    }

    override fun hidePlaceholder() {
        ph_data?.visibility = View.GONE
    }

}
