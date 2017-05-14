package pl.edu.pwr.wojciech.okonski.lab2.lab2.fragments


import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.edu.pwr.wojciech.okonski.lab2.lab2.R


class ImagesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.fragment_images, container, false)

}
