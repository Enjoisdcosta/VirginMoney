package com.example.virginmoney.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.virginmoney.R
import com.example.virginmoney.data.model.people.PeopleItemModel
import com.example.virginmoney.databinding.ItemPeopleBinding

class PeopleAdapter(
    val peopleList: List<PeopleItemModel>,
    val function: (PeopleItemModel) -> Unit
) : Adapter<PeopleAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val binding = ItemPeopleBinding.bind(itemView)

        fun updateUI(peopleItemModel: PeopleItemModel) {
            // handle the ui changes based on current data
            binding.apply {
                Glide.with(itemView.context).load(peopleItemModel.avatar)
                    .placeholder(R.drawable.people_icon)
                    .into(ivProfile)

                tvFirstName.text = "Name: ${peopleItemModel.firstName} ${peopleItemModel.lastName}"
                //  tvLastName.text = "${peopleItemModel.lastName}"
                tvEmail.text = "Email: ${peopleItemModel.email}"
                tvJobTitle.text = "Job Title: ${peopleItemModel.jobtitle}"

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        )
    }

    override fun getItemCount() = peopleList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateUI(peopleList[position])
        holder.binding.root.setOnClickListener {
            function.invoke(peopleList[position])
        }
    }
}