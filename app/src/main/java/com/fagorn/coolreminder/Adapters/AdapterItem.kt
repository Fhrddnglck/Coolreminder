package com.fagorn.coolreminder.Adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fagorn.coolreminder.Model.ItemModel


/** Code passion <3

Created By Fahreddin GÖLCÜK

Fahreddingolcuk@gmail.com

(((   24/05/2020 - 3:11 AM   )))

 **/
class AdapterItem(val taskList:MutableList<ItemModel>) : RecyclerView.Adapter<ItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bindItems(taskList.get(position))
    }
    fun removeItem(viewHolder : RecyclerView.ViewHolder){
        taskList.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }
}