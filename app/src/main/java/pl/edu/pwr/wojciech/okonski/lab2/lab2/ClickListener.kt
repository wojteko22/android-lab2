package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.view.View

interface ClickListener {
    fun onClick(view: View, position: Int)

    fun onLongClick(view: View, position: Int)
}