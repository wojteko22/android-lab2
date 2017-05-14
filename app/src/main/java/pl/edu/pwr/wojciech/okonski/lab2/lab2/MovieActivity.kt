package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieFragment = MovieFragment()
        movieFragment.arguments = intent.extras
        val transaction = fragmentManager.beginTransaction()
        with(transaction) {
            add(android.R.id.content, movieFragment)
            commit()
        }
    }
}
