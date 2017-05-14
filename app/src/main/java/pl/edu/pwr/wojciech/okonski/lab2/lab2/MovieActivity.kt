package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        val fragment = MovieFragment()
        fragment.arguments = intent.extras
        val transaction = fragmentManager.beginTransaction()
        with(transaction) {
            add(R.id.outer_container, fragment)
            commit()
        }
    }
}
