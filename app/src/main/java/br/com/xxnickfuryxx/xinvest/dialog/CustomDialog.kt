package br.com.xxnickfuryxx.xinvest.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import br.com.xxnickfuryxx.xinvest.R

class CustomDialog(context: Context?) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_layout)
    }

}