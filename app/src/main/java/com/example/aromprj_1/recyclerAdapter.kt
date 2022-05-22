package com.example.aromprj_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_room.view.*


class recyclerAdapter() : RecyclerView.Adapter<recyclerAdapter.ViewHolder>() {
    var items = ArrayList<roomInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_room,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)

        holder.itemView.setOnClickListener {
            Toast.makeText(it.context,"${position+1} 아이템 클릭!",Toast.LENGTH_SHORT).show()
        }
    }
    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item:roomInfo) {
            itemView.roomName.text="방탈출카페 이름"
            itemView.roomAddress.text="주소"
            itemView.roomNote.text ="상세설명"
        }
    }
}