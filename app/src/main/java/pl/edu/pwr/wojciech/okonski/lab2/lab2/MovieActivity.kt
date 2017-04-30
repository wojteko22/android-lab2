package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        showInfo()
    }

    private fun showInfo() {
        tvTitle.text = intent.extras.getString(TITLE)
    }

    companion object {
        private val TITLE = "TITLE"

        fun getStartingIntent(context: Context, title: String): Intent {
            val intent = Intent(context, MovieActivity::class.java)
            intent.putExtra(TITLE, title)
            return intent
        }
    }
}
