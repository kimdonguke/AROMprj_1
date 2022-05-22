package com.example.aromprj_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_recycler.*
import kotlinx.android.synthetic.main.recycler_room.*

class RecyclerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        roomRecycler.layoutManager = layoutManager
        val adapter= viewPagerAdapter()

        for (i in 0 until 2) {
            val name = "roomName"
            val address = "roomAddress"
            val note="roomNote"

            adapter.items.add(roomInfo(name,address,note))
        }

        roomRecycler.adapter=adapter

    }

}