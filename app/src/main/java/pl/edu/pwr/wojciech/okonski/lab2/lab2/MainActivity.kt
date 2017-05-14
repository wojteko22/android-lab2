package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import pl.edu.pwr.wojciech.okonski.lab2.lab2.fragments.MovieFragment
import pl.edu.pwr.wojciech.okonski.lab2.lab2.model.Movie
import pl.edu.pwr.wojciech.okonski.lab2.lab2.model.MovieGenre
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private var adapter: MoviesAdapter by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setRecyclerView()
        swipeToDismissTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun setRecyclerView() {
        adapter = MoviesAdapter(movieList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.itemAnimator = DefaultItemAnimator()
    }

    val swipeToDismissTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?) = false
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            deleteItem(viewHolder)
        }
    })

    private fun deleteItem(viewHolder: RecyclerView.ViewHolder) {
        val position = viewHolder.adapterPosition
        movieList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    override fun onItemClick(position: Int) {
        val intent = MovieFragment.getStartingIntent(this, position)
        startActivity(intent)
    }

    override fun onItemLongClick(position: Int) {
        val movie = movieList[position]
        movie.changeSeen()
        adapter.notifyItemChanged(position)
    }
}

val movieList = arrayListOf(
        Movie("Mad Max: Fury Road", MovieGenre.ACTION, "2015"),
        Movie("Inside Out", MovieGenre.ANIMATION, "2015"),
        Movie("Star Wars: Episode VII - The Force Awakens", MovieGenre.ACTION, "2015"),
        Movie("Shaun the Sheep", MovieGenre.ANIMATION, "2015"),
        Movie("The Martian", MovieGenre.FANTASY, "2015"),
        Movie("Mission: Impossible Rogue Nation", MovieGenre.ACTION, "2015"),
        Movie("Up", MovieGenre.ANIMATION, "2009"),
        Movie("Star Trek", MovieGenre.FANTASY, "2009"),
        Movie("The LEGO Movie", MovieGenre.ANIMATION, "2014"),
        Movie("Iron Man", MovieGenre.ACTION, "2008"),
        Movie("Aliens", MovieGenre.FANTASY, "1986"),
        Movie("Chicken Run", MovieGenre.ANIMATION, "2000"),
        Movie("Back to the Future", MovieGenre.FANTASY, "1985"),
        Movie("Raiders of the Lost Ark", MovieGenre.ACTION, "1981"),
        Movie("Goldfinger", MovieGenre.ACTION, "1965"),
        Movie("Guardians of the Galaxy", MovieGenre.FANTASY, "2014")
)