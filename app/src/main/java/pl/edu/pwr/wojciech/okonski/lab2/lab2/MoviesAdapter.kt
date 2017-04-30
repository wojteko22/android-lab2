package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class MoviesAdapter(private val moviesList: List<Movie>, private val listener: OnItemClickListener) : RecyclerView.Adapter<MoviesViewHolder>() {
    private val imageLeft = 0
    private val imageRight = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView =
                if (viewType == imageLeft)
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.movie_list_row, parent, false)
                else LayoutInflater.from(parent.context)
                        .inflate(R.layout.movie_list_row_image_right, parent, false)
        return MoviesViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.title.text = movie.title
        holder.genre.text = movie.genre
        holder.year.text = movie.year
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) imageLeft else imageRight
    }
}