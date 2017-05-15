package pl.edu.pwr.wojciech.okonski.lab2.lab2.fragments

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie.*
import pl.edu.pwr.wojciech.okonski.lab2.lab2.MovieActivity
import pl.edu.pwr.wojciech.okonski.lab2.lab2.R
import pl.edu.pwr.wojciech.okonski.lab2.lab2.movieList

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
        btnInfo.setOnClickListener { startInfoFragments() }
    }

    private fun showInfo() {
        val index = arguments.getInt(INDEX)
        val movie = movieList[index]
        tvTitle.text = movie.title
        ivMovieImage.setImageResource(movie.genre.imageResource)
        tvDescription.text = getString(movie.descriptionResource)
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

    private fun startInfoFragments() {
        val outerFragment = fragmentManager.findFragmentById(R.id.outer_container)
        val actorsFragment = ActorsFragment()
        actorsFragment.arguments = arguments
        val imagesFragment = ImagesFragment()
        imagesFragment.arguments = arguments
        val transaction = fragmentManager.beginTransaction()
        with(transaction) {
            detach(outerFragment)
            add(R.id.upper_inner_container, imagesFragment)
            add(R.id.lower_inner_container, actorsFragment)
            addToBackStack(null)
            commit()
        }
    }

    companion object {
        val INDEX = "INDEX"

        fun getStartingIntent(context: Context, index: Int): Intent {
            val intent = Intent(context, MovieActivity::class.java)
            return intent.putExtra(INDEX, index)
        }
    }
}
