package br.com.xxnickfuryxx.xinvest.models

import java.util.*
import kotlin.collections.ArrayList

class BalanceInvestiment {

    var _id: String? = null
    var idIncome: Int? = null
    var idInvest: Int? = null
    var idUser: Long? = null
    var valueInvest: Double? = null
    var valueRefresh: Double? = null
    var date: Date? = null
    var investiment: ArrayList<Investiment>? = null

}