package com.example.aromprj_1.Category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aromprj_1.R
import com.example.aromprj_1.RecyclerRoomAdapter
import com.example.aromprj_1.RoomInfo
import kotlinx.android.synthetic.main.fragment_category_item2.*

// 네비게이션 - 카테고리 - 지역
class CategoryFragmentItem2 : Fragment() {
    val itemArray = listOf("전체","서울시","광진구","의정부시")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category_item2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        recyclerLocal.layoutManager=layoutManager
        val adapter= RecyclerRoomAdapter()

        for (i in 0 until 10) {
            val name = "방탈출"
            val address = "의정부시"
            val info = "안녕"

            adapter.items.add(RoomInfo(name, address, info))
        }
        recyclerLocal.adapter=adapter

        val dropdownAdapter=ArrayAdapter(requireContext(),R.layout.support_simple_spinner_dropdown_item,itemArray)
        dropdownAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        category_local_spinner.adapter=dropdownAdapter

        var selectArray= ArrayList<RoomInfo>()
        selectArray.addAll(adapter.items)
        category_local_spinner.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position!=0) {
                    adapter.items.clear()
                    for (i in 0 until selectArray.size) {
                        if (selectArray[i].roomAddress.equals(itemArray[position])) {
                            adapter.items.add(selectArray[i])
                        }
                    }
                }
                else if (position==0){
                    adapter.items.addAll(selectArray)
                }
                recyclerLocal.adapter=adapter
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }
}