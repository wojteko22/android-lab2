package pl.edu.pwr.wojciech.okonski.lab2.lab2

import android.view.View

interface OnItemClickListener {
    fun onItemClick(position: Int)

    fun onLongItemClick(view: View, position: Int)
}