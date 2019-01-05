package br.com.xxnickfuryxx.xinvest.ui.main

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import br.com.xxnickfuryxx.xinvest.R
import br.com.xxnickfuryxx.xinvest.adapter.BalanceInvestimentAdapter
import br.com.xxnickfuryxx.xinvest.models.BalanceInvestiment
import br.com.xxnickfuryxx.xinvest.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), IMainView {

    private var presenter: IMainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter()

        init()

    }

    private fun init() {

        lvBalanceInvestiments.setOnItemClickListener { adapterView, view, i, l ->
            var balance = adapterView.getItemAtPosition(i) as BalanceInvestiment
            Log.i(MainActivity::class.java.name, balance._id)
        }

        btnGetListBalance.setOnClickListener(({
            presenter!!.getBalanceInvestiments()
        }))

    }


    override fun onResume() {
        super.onResume()
        presenter!!.setView(this)
    }

    override fun showListBalanceInvestments(list: List<BalanceInvestiment>?) {
        var adapter = BalanceInvestimentAdapter(this, list!!)
        lvBalanceInvestiments.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun goServiceError() {
        var dialog = AlertDialog.Builder(this)
        dialog.setMessage("Algo aconteceu e não conseguimos processar sua requisição")
        dialog.setPositiveButton("Ok", ({ dialogInterface, _ -> dialogInterface.dismiss() }))
        dialog.show()
    }


}
