package com.example.virginmoney.ui.room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.data.model.room.RoomItemModel
import com.example.virginmoney.databinding.ItemPeopleBinding
import com.example.virginmoney.databinding.ItemRoomBinding

class RoomAdapter(
    val roomList: List<RoomItemModel>
) : Adapter<RoomAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding = ItemRoomBinding.bind(itemView)

        fun updateUI(roomItemModel: RoomItemModel) {
            // handle the ui changes based on current data
            binding.apply {
//                Glide.with(itemView.context).load(peopleItemModel.avatar)
//                    .placeholder(R.drawable.people_icon)
//                    .into(ivProfile)
                tvRoomId.text = "Room id: ${roomItemModel.id}"
                tvMaxRoom.text = "Max Occupancy: ${roomItemModel.maxOccupancy.toString()}"
                if (roomItemModel.isOccupied==true){
//                    ItemRoomBinding.bind(itemView.background= "@color/green")
                }


            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_room, parent, false)
        )
    }

    override fun getItemCount() = roomList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateUI(roomList[position])
    }
}