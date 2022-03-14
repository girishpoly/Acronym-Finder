package com.acronymtest.ui

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("dividerItemDecoration")
fun dividerItemDecoration(recyclerView: RecyclerView, showDivider: Boolean) =
    recyclerView.addItemDecoration(
        DividerItemDecoration(recyclerView.context, LinearLayoutManager.VERTICAL)
    )