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
        readSavedData()
        ratingBar.setOnRatingBarChangeListener { _, rating, _ -> saveData(rating) }
    }

    private fun showInfo() {
        val extras = intent.extras
        tvTitle.text = extras.getString(TITLE)
        ivMovieImage.setImageResource(extras.getInt(IMAGE))
        tvDescription.text = extras.getString(DESCRIPTION)
    }

    private fun saveData(rating: Float) {
        val data = getPreferences(Context.MODE_PRIVATE)
        val editor = data.edit()
        editor.putFloat(tvTitle.text.toString(), rating)
        editor.apply()
    }

    private fun readSavedData() {
        val data = getPreferences(Context.MODE_PRIVATE)
        ratingBar.rating = data.getFloat(tvTitle.text.toString(), 0f)
    }

    companion object {
        private val TITLE = "TITLE"
        private val IMAGE = "IMAGE"
        private val DESCRIPTION = "DESCRIPTION"

        fun getStartingIntent(context: Context, title: String, imageResource: Int, description: String): Intent {
            val intent = Intent(context, MovieActivity::class.java)
            intent.putExtra(TITLE, title)
            intent.putExtra(IMAGE, imageResource)
            intent.putExtra(DESCRIPTION, description)
            return intent
        }
    }
}
