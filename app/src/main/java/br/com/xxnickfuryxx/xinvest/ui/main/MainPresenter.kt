package br.com.xxnickfuryxx.xinvest.ui.main

import br.com.xxnickfuryxx.xinvest.models.BalanceInvestiment
import br.com.xxnickfuryxx.xinvest.models.User
import br.com.xxnickfuryxx.xinvest.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : IMainPresenter {

    var mView : IMainView? = null

    override fun setView(mView: IMainView) {
        this.mView = mView
    }

    override fun getBalanceInvestiments(){

        mView!!.showDialog()

        var retrofit = ApiService.Companion.getInstance()
        var services = retrofit.create(ApiService.Services::class.java)


        var user = User()
        user.idUser = 30384673830L

        var call = services.getBalanceInvestiments(user)

        //Para execute()
//        var response = call.execute()
//        if (response.isSuccessful) {
//            mView.hideDialog()
//
//
//        } else {
//            mView.hideDialog()
//
//        }

        // para enqueue
        call.enqueue(object: Callback<List<BalanceInvestiment>?>{
            override fun onResponse(
                call: Call<List<BalanceInvestiment>?>,
                response: Response<List<BalanceInvestiment>?>) {
                mView!!.hideDialog()
                mView!!.showListBalanceInvestments(response.body())

            }

            override fun onFailure(call: Call<List<BalanceInvestiment>?>, t: Throwable) {
                mView!!.hideDialog()
                mView!!.goServiceError()

            }
        })

    }


}