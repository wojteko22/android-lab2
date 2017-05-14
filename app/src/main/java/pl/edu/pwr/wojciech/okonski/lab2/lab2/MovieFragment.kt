package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    val data: SharedPreferences by lazy { activity.getPreferences(Context.MODE_PRIVATE) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showInfo()
        readSavedData()
        ratingBar.setOnRatingBarChangeListener { _, rating, _ -> saveData(rating) }
    }

    private fun showInfo() {
        tvTitle.text = arguments.getString(TITLE)
        ivMovieImage.setImageResource(arguments.getInt(IMAGE))
        tvDescription.text = arguments.getString(DESCRIPTION)
    }

    private fun readSavedData() {
        ratingBar.rating = data.getFloat(tvTitle.text.toString(), 0f)
    }

    private fun saveData(rating: Float) {
        val editor = data.edit()
        with(editor) {
            putFloat(tvTitle.text.toString(), rating)
            apply()
        }
    }

    companion object {
        private val TITLE = "TITLE"
        private val IMAGE = "IMAGE"
        private val DESCRIPTION = "DESCRIPTION"

        fun getStartingIntent(context: Context, title: String, imageResource: Int, description: String): Intent {
            val intent = Intent(context, MovieActivity::class.java)
            with(intent) {
                putExtra(TITLE, title)
                putExtra(IMAGE, imageResource)
                putExtra(DESCRIPTION, description)
            }
            return intent
        }
    }
}
