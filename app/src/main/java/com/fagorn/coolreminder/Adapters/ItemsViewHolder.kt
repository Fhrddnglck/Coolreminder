package com.fagorn.coolreminder.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fagorn.coolreminder.Model.ItemModel
import com.fagorn.coolreminder.R
import org.w3c.dom.Text


/** Code passion <3

Created By Fahreddin GÖLCÜK

Fahreddingolcuk@gmail.com

(((   24/05/2020 - 3:12 AM   )))

 **/
class ItemsViewHolder(container: ViewGroup) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(container.context).inflate(
            R.layout.item_view,
            container,
            false
        )
    ) {
    val taskHeader: TextView = itemView.findViewById(R.id.taskHeader)
    val taskDetail: TextView = itemView.findViewById(R.id.taskDetail)
    val taskTime: TextView = itemView.findViewById(R.id.taskTime)
    val taskDate : TextView = itemView.findViewById(R.id.taskDate)
    fun bindItems(item: ItemModel) {
        taskHeader.text = item.taskHeader
        taskDetail.text = item.taskDetail
        if(item.taskTime.hours.toInt() < 10){
            if(item.taskTime.minute.toInt()<10){
                taskTime.text = "0${item.taskTime.hours}.0${item.taskTime.minute}"
            }else{
                taskTime.text = "0${item.taskTime.hours}.${item.taskTime.minute}"
            }
        }else{
            if (item.taskTime.minute.toInt()<10){
                taskTime.text = "${item.taskTime.hours}.0${item.taskTime.minute}"
            }else{
                taskTime.text = "${item.taskTime.hours}.${item.taskTime.minute}"
            }
        }
        taskDate.text = "${item.taskDate.day}/${item.taskDate.month}/${item.taskDate.year}"
    }
}