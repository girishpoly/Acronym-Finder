package com.acronymtest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.acronymtest.R
import com.acronymtest.databinding.FullFormItemRowBinding
import com.acronymtest.model.FullForm

class AcronymsListAdapter(
    private var fullFormList: MutableList<FullForm>
) : RecyclerView.Adapter<AcronymsListAdapter.AcronymItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcronymItemViewHolder {
        return AcronymItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.full_form_item_row, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AcronymItemViewHolder, position: Int) {
        holder.bind(fullFormList[position])
    }

    fun updateList(list: List<FullForm>) {
        fullFormList.clear()
        fullFormList.addAll(list)
        notifyDataSetChanged()
    }

    fun clearList() {
        fullFormList.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = fullFormList.size


    class AcronymItemViewHolder(private val binding: FullFormItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            fullForm: FullForm
        ) {
            binding.fullForm = fullForm
        }
    }

}


