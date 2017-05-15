package pl.edu.pwr.wojciech.okonski.lab2.lab2.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_images.*
import pl.edu.pwr.wojciech.okonski.lab2.lab2.R
import pl.edu.pwr.wojciech.okonski.lab2.lab2.movieList

class ImagesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.fragment_images, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showImages()
    }

    private fun showImages() {
        val index = arguments.getInt(MovieFragment.INDEX)
        val movie = movieList[index]
        setStills(movie.images)
    }

    private fun setStills(images: List<Int>) {
        ivStill1.setImageResource(images[0])
        ivStill2.setImageResource(images[1])
        ivStill3.setImageResource(images[2])
        ivStill4.setImageResource(images[3])
        ivStill5.setImageResource(images[4])
        ivStill6.setImageResource(images[5])
    }

    companion object {
        val INDEX = "INDEX"

        fun newInstance(index: Int): ImagesFragment {
            val instance = ImagesFragment()
            val args = Bundle()
            args.putInt(INDEX, index)
            instance.arguments = args
            return instance
        }
    }
}
