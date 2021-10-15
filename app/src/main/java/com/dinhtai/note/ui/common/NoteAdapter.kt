package com.dinhtai.note.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dinhtai.note.data.entity.NoteEdit
import com.dinhtai.note.databinding.ItemNoteEditBinding

class NoteAdapter(private val onClick: (item: NoteEdit) -> Unit) :
    RecyclerView.Adapter<NoteAdapter.BindingHolder>() {

    private var datas = mutableListOf<NoteEdit>()

    fun setItemList(itemList: List<NoteEdit>?) {
        val newList = itemList ?: emptyList()
        val diff = DiffUtil.calculateDiff(ListDiffCallback(datas, newList), false)
        datas.apply {
            clear()
            addAll(newList)
        }
        diff.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteEditBinding.inflate(layoutInflater, parent, false)
        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.binding.note = datas[position]
        holder.binding.root.setOnClickListener {
            onClick(datas.get(position))
        }
    }

    override fun getItemCount() = datas.size

    class ListDiffCallback(
        private val oldItems: List<NoteEdit>,
        private val newItems: List<NoteEdit>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldItems.size
        override fun getNewListSize() = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItems[oldItemPosition].noteId == newItems[newItemPosition].noteId
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItems[oldItemPosition].content == newItems[newItemPosition].content &&
                    oldItems[oldItemPosition].noteId == newItems[newItemPosition].noteId
        }
    }

    class BindingHolder(val binding: ItemNoteEditBinding) : RecyclerView.ViewHolder(binding.root)
}