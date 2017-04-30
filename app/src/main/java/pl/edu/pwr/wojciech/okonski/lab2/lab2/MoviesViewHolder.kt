package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.movie_list_row.view.*

class MoviesViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
    val title: TextView = view.title
    val year: TextView = view.year
    val genre: TextView = view.genre

    init {
        view.setOnClickListener { listener.onItemClick(adapterPosition) }
    }
}