package com.lambdasoup.kotlinandroidextensionsexample

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.list_item.view.*
import java.util.*

data class Item(val rank: Int, val name: String)

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var dataset = listOf<Item>()

    private val random = Random()

    fun addItem() {
        dataset += Item(dataset.size + 1, NAMES[random.nextInt(NAMES.size)])
        notifyItemInserted(dataset.lastIndex)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(dataset[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: Item) {
            with(itemView.rank) {
                text = item.rank.toString()
                val rankColor = ContextCompat.getColor(
                        context,
                        when {
                            item.rank <= 3 -> android.R.color.holo_green_dark
                            item.rank <= 6 -> android.R.color.holo_orange_dark
                            else -> android.R.color.holo_red_dark
                        }
                )
                setTextColor(rankColor)
            }

            itemView.name_line.text = item.name
        }
    }

    companion object {
        private val NAMES = listOf(
                "Cupcake",
                "Donut",
                "Eclair",
                "Froyo",
                "Gingerbread",
                "Honeycomb",
                "Ice Cream Sandwich",
                "Jelly Bean",
                "KitKat",
                "Lollipop",
                "Marshmallow",
                "Nougat",
                "Oreo"
        )
    }
}
