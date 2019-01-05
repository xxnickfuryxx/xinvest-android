package br.com.xxnickfuryxx.xinvest.ui.main

import br.com.xxnickfuryxx.xinvest.models.BalanceInvestiment

interface IMainView {

    fun showDialog()
    fun hideDialog()

    fun showListBalanceInvestments(list: List<BalanceInvestiment>?)

    fun goServiceError()
}