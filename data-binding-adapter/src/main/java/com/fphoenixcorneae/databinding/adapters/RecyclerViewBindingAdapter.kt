package com.fphoenixcorneae.databinding.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fphoenixcorneae.widget.OnLoadMoreListener
import com.fphoenixcorneae.widget.OnScrollLoadMoreListener

@BindingAdapter(value = ["adapter", "manager"], requireAll = false)
fun initRecycler(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<*>? = null,
    layoutManager: RecyclerView.LayoutManager? = LinearLayoutManager(recyclerView.context),
) {
    adapter?.also {
        recyclerView.adapter = it
    }
    layoutManager?.also {
        recyclerView.layoutManager = it
    }
}

@BindingAdapter(value = ["onLoadMore"], requireAll = false)
fun setOnLoadMoreListener(
    recyclerView: RecyclerView,
    onLoadMoreListener: OnLoadMoreListener
) {
    recyclerView.addOnScrollListener(OnScrollLoadMoreListener(onLoadMoreListener = onLoadMoreListener))
}
