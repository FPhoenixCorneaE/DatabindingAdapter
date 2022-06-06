package com.fphoenixcorneae.databinding.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fphoenixcorneae.databinding.widget.databinding.ItemRecyclerBinding

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemRecyclerBinding? get() = DataBindingUtil.getBinding(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.apply {
            index = position
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return 10
    }
}