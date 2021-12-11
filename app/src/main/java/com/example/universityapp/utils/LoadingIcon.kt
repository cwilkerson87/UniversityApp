package com.example.universityapp.utils

import android.app.Activity
import android.app.AlertDialog
import com.example.universityapp.R

class LoadingIcon(val activity: Activity) {

    private lateinit var isdialog: AlertDialog
    fun startLoading(){
        val infalter =  activity.layoutInflater
//        val dialog = infalter.inflate(R.layout.activity_splash,null)
        val builder = AlertDialog.Builder(activity)
//        builder.setView(dialog)
        builder.setCancelable(false)
        isdialog = builder.create()
        isdialog.show()

    }

    fun isDone(){
        isdialog.dismiss()
    }

}