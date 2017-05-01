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
import java.util.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private val movieList = ArrayList<Movie>()
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
        prepareMovieData()
    }

    private fun prepareMovieData() {
        movieList += arrayOf(
                Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.madmax),
                Movie("Inside Out", "Animation, Kids & Family", "2015"),
                Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015"),
                Movie("Shaun the Sheep", "Animation", "2015"),
                Movie("The Martian", "Science Fiction & Fantasy", "2015"),
                Movie("Mission: Impossible Rogue Nation", "Action", "2015"),
                Movie("Up", "Animation", "2009"),
                Movie("Star Trek", "Science Fiction", "2009"),
                Movie("The LEGO Movie", "Animation", "2014"),
                Movie("Iron Man", "Action & Adventure", "2008"),
                Movie("Aliens", "Science Fiction", "1986"),
                Movie("Chicken Run", "Animation", "2000"),
                Movie("Back to the Future", "Science Fiction", "1985"),
                Movie("Raiders of the Lost Ark", "Action & Adventure", "1981"),
                Movie("Goldfinger", "Action & Adventure", "1965"),
                Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014")
        )
        adapter.notifyDataSetChanged()
    }

    val swipeToDismissTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
            return false
        }

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
        val movie = movieList[position]
        val intent = MovieActivity.getStartingIntent(this, movie.title, movie.imageResource)
        startActivity(intent)
    }
}