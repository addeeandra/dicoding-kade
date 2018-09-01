package com.potetostudio.footballapps.util

import android.app.Activity
import android.content.Intent
import com.potetostudio.footballapps.view.eventsDetail.EventsDetailActivity
import com.potetostudio.footballapps.view.eventsSearch.EventsSearchActivity
import com.potetostudio.footballapps.view.playersDetail.PlayersDetailActivity
import com.potetostudio.footballapps.view.teamsDetail.TeamsDetailActivity
import com.potetostudio.footballapps.view.teamsSearch.TeamsSearchActivity

fun Activity.openEventsSearch() {
    startActivity(Intent(this, EventsSearchActivity::class.java))
}

fun Activity.openTeamsSearch() {
    startActivity(Intent(this, TeamsSearchActivity::class.java))
}

fun Activity.openEventsDetail(eventId: String) {
    startActivity(Intent(this, EventsDetailActivity::class.java).apply {
        putExtra("EVENT_ID", eventId)
    })
}

fun Activity.openTeamsDetail(teamId: String) {
    startActivity(Intent(this, TeamsDetailActivity::class.java).apply {
        putExtra("TEAM_ID", teamId)
    })
}

fun Activity.openPlayersDetail(playerId: String) {
    startActivity(Intent(this, PlayersDetailActivity::class.java).apply {
        putExtra("PLAYER_ID", playerId)
    })
}
