package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.edu.pwr.wojciech.okonski.lab2.lab2.fragments.MovieFragment

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        addMovieFragmentIfThereIsNotInner()
    }

    private fun addMovieFragmentIfThereIsNotInner() {
        val innerFragment: Fragment? = fragmentManager.findFragmentById(R.id.upper_inner_container)
        if (innerFragment == null)
            addMovieFragment()
    }

    private fun addMovieFragment() {
        val movieFragment = MovieFragment()
        movieFragment.arguments = intent.extras
        val transaction = fragmentManager.beginTransaction()
        with(transaction) {
            add(R.id.outer_container, movieFragment)
            commit()
        }
    }
}
