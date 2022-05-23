package com.example.aromprj_1.bottomNavigationFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aromprj_1.R
import com.example.aromprj_1.RecyclerRoomAdapter
import com.example.aromprj_1.RoomInfo
import kotlinx.android.synthetic.main.fragment_category_item1.*
// 네비게이션 - 카테고리 - 장르
class CategoryFragmentItem1 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category_item1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager =LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerLocal.layoutManager=layoutManager
        val adapter= RecyclerRoomAdapter()

        for (i in 0 until 10) {
            val name = "방탈출"
            val address = "광진구"
            val info = "안녕하세요"

            adapter.items.add(RoomInfo(name, address, info))
        }
        recyclerLocal.adapter=adapter
    }
}
