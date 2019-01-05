package br.com.xxnickfuryxx.xinvest.ui

import android.support.v7.app.AppCompatActivity
import br.com.xxnickfuryxx.xinvest.dialog.CustomDialog

open class BaseActivity : AppCompatActivity() {

    private var dialog : CustomDialog? = null

    fun showDialog() {

        dialog = CustomDialog(this)
        dialog!!.show();

    }

    fun hideDialog() {
        if(dialog != null){
            dialog!!.dismiss()
            dialog = null
        }
    }

}