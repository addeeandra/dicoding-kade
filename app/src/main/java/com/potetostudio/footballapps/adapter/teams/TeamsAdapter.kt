package com.potetostudio.footballapps.adapter.teams

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.potetostudio.footballapps.R
import com.potetostudio.footballapps.data.remote.response.TeamResponse

class TeamsAdapter(private val mItems: List<TeamResponse.Team>,
                   private val mOnClick: (team: TeamResponse.Team) -> Unit)
    : RecyclerView.Adapter<TeamsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TeamsViewHolder(inflater.inflate(R.layout.item_list_team, parent, false))
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        holder.bind(mItems[position], mOnClick)
    }

}