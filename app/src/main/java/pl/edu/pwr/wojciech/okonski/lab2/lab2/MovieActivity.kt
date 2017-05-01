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
        val extras = intent.extras
        tvTitle.text = extras.getString(TITLE)
        ivMovieImage.setImageResource(extras.getInt(IMAGE))
    }

    companion object {
        private val TITLE = "TITLE"
        private val IMAGE = "IMAGE"

        fun getStartingIntent(context: Context, title: String, imageResource: Int): Intent {
            val intent = Intent(context, MovieActivity::class.java)
            intent.putExtra(TITLE, title)
            intent.putExtra(IMAGE, imageResource)
            return intent
        }
    }
}
