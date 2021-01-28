package com.pparreno.kotlintrntasklist.ui.views

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import com.pparreno.kotlintrntasklist.R

class LoadingDialog(var activity: Activity) {

    private lateinit var dialog: AlertDialog

    @SuppressLint("InflateParams")
    fun startLoadingDialog(){
        val dialogBuilder : AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflater : LayoutInflater = activity.layoutInflater
        dialogBuilder.setView(inflater.inflate(R.layout.dialog_loading, null, false))
        dialogBuilder.setCancelable(false)

        dialog = dialogBuilder.create()
        dialogBuilder.show()
    }

    fun dismissDialog()
    {
        Log.d("LoadingDialog", "dismissDialog")
        if(dialog.isShowing)
        {
            Log.d("LoadingDialog", "dialog is showing")
            dialog.dismiss()
        }
    }

}