package pl.edu.pwr.wojciech.okonski.lab2.lab2.fragments

import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_actors.*
import pl.edu.pwr.wojciech.okonski.lab2.lab2.movieList

class ActorsFragment : android.app.Fragment() {
    override fun onCreateView(inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
                              savedInstanceState: android.os.Bundle?): android.view.View? =
            inflater.inflate(pl.edu.pwr.wojciech.okonski.lab2.lab2.R.layout.fragment_actors, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showActors()
    }

    private fun showActors() {
        val index = arguments.getInt(MovieFragment.INDEX)
        val movie = movieList[index]
        tvActor1.text = movie.actors[0].fullName
        tvActor2.text = movie.actors[1].fullName
        tvActor3.text = movie.actors[2].fullName
    }
}
