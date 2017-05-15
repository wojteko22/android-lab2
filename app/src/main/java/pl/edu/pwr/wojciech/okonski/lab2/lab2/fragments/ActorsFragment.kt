package pl.edu.pwr.wojciech.okonski.lab2.lab2.fragments

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_actors.*
import pl.edu.pwr.wojciech.okonski.lab2.lab2.model.Actor
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
        set(tvActor1, ivActor1, movie.actors[0])
        set(tvActor2, ivActor2, movie.actors[1])
        set(tvActor3, ivActor3, movie.actors[2])
    }

    private fun set(textView: TextView, imageView: ImageView, actor: Actor) {
        textView.text = actor.fullName
        imageView.setImageResource(actor.imageResource)
    }

    companion object {
        val INDEX = "INDEX"

        fun newInstance(index: Int): ActorsFragment {
            val instance = ActorsFragment()
            val args = Bundle()
            args.putInt(INDEX, index)
            instance.arguments = args
            return instance
        }
    }
}
