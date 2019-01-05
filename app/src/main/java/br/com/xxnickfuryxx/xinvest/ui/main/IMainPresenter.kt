package br.com.xxnickfuryxx.xinvest.ui.main

import br.com.xxnickfuryxx.xinvest.models.BalanceInvestiment

interface IMainPresenter {

    fun setView(mView: IMainView)

    fun getBalanceInvestiments()

}