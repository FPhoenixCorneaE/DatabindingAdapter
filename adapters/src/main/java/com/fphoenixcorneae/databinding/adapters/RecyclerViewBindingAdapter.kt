package com.fphoenixcorneae.databinding.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.fphoenixcorneae.widget.OnLoadMoreListener
import com.fphoenixcorneae.widget.OnScrollLoadMoreListener

@BindingAdapter(
    value = [
        "adapter",
        "layoutManager",
        "hasFixedSize",
        "itemDecorations",
    ],
    requireAll = false
)
fun initRecycler(
    recyclerView: RecyclerView,
    adapter: RecyclerView.Adapter<*>? = null,
    layoutManager: RecyclerView.LayoutManager? = LinearLayoutManager(recyclerView.context),
    hasFixedSize: Boolean? = true,
    itemDecorations: List<ItemDecoration>? = null,
) {
    adapter?.let {
        recyclerView.adapter = it
    }
    layoutManager?.let {
        recyclerView.layoutManager = it
    }
    hasFixedSize?.let {
        recyclerView.setHasFixedSize(it)
    }
    itemDecorations?.forEach {
        recyclerView.removeItemDecoration(it)
        recyclerView.addItemDecoration(it)
    }
}

@BindingAdapter(value = ["onLoadMore"], requireAll = false)
fun setOnLoadMoreListener(
    recyclerView: RecyclerView,
    onLoadMoreListener: OnLoadMoreListener
) {
    recyclerView.addOnScrollListener(OnScrollLoadMoreListener(onLoadMoreListener = onLoadMoreListener))
}
