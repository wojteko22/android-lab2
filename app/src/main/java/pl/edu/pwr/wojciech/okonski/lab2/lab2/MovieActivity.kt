package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.edu.pwr.wojciech.okonski.lab2.lab2.fragments.MovieFragment

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        if (savedInstanceState == null)
            addMovieFragmentIfThereIsNotInner()
    }

    private fun addMovieFragmentIfThereIsNotInner() {
        val innerFragment: Fragment? = fragmentManager.findFragmentById(R.id.upper_inner_container)
        if (innerFragment == null)
            addMovieFragment()
    }

    private fun addMovieFragment() {
        val index = intent.extras.getInt(INDEX)
        val movieFragment = MovieFragment.newInstance(index)
        val transaction = fragmentManager.beginTransaction()
        with(transaction) {
            add(R.id.outer_container, movieFragment)
            commit()
        }
    }

    override fun onSupportNavigateUp() =
            if (fragmentManager.backStackEntryCount > 0) {
                fragmentManager.popBackStack()
                false
            } else
                super.onSupportNavigateUp()

    companion object {
        private val INDEX = "INDEX"

        fun getStartingIntent(context: Context, index: Int): Intent {
            val intent = Intent(context, MovieActivity::class.java)
            return intent.putExtra(INDEX, index)
        }
    }
}
