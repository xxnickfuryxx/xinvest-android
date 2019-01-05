package br.com.xxnickfuryxx.xinvest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.com.xxnickfuryxx.xinvest.R
import br.com.xxnickfuryxx.xinvest.models.BalanceInvestiment
import java.text.NumberFormat
import java.text.SimpleDateFormat

class BalanceInvestimentAdapter : BaseAdapter {

    var mContext: Context? = null
    var mList: List<BalanceInvestiment>? = null

    constructor(context: Context?, list: List<BalanceInvestiment>?): super() {

        this.mContext = context
        this.mList = list

    }

    override fun getView(pos: Int, v: View?, vg: ViewGroup?): View {

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val nf = NumberFormat.getCurrencyInstance()

        var layoutInflater: LayoutInflater = LayoutInflater.from(mContext)
        var view = layoutInflater.inflate(R.layout.adapter_balance_investiment, vg,false)

        var vh = ViewHolder(view)
        vh.tvCodInvestiment!!.text = mList!![pos].idInvest.toString() + " - " + mList!![pos].investiment!!.get(0).name
        vh.tvValueInvestiment!!.text = nf.format(mList!![pos].valueInvest)
        vh.tvValueYield!!.text = nf.format(mList!![pos].valueRefresh)
        vh.tvDateUpdate!!.text = sdf.format(mList!![pos].date) + " - " + mList!![pos].investiment!!.get(0).update

        return view

    }

    override fun getItem(pos: Int): Any? {
        return mList!!.get(pos)
    }

    override fun getItemId(pos: Int): Long {
        return mList!!.get(pos).idIncome!!.toLong()
    }

    override fun getCount(): Int {
        return mList!!.size
    }

    private class ViewHolder(view: View?){

        val tvCodInvestiment: TextView
        val tvValueInvestiment: TextView
        val tvValueYield: TextView
        val tvDateUpdate: TextView

        init {
            this.tvCodInvestiment = view?.findViewById(R.id.tvCodInvestiment) as TextView
            this.tvValueInvestiment = view?.findViewById(R.id.tvValueInvestiment) as TextView
            this.tvValueYield = view?.findViewById(R.id.tvValueYield) as TextView
            this.tvDateUpdate = view?.findViewById(R.id.tvDateUpdate) as TextView
        }

    }
}