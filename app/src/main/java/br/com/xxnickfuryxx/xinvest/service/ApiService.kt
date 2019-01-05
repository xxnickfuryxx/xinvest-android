package br.com.xxnickfuryxx.xinvest.service

import br.com.xxnickfuryxx.xinvest.models.BalanceInvestiment
import br.com.xxnickfuryxx.xinvest.models.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class ApiService {


    companion object {

        //local
        var BASE_URL = "http://192.168.1.36:8080"
        var retrofit : Retrofit? = null

        fun getInstance() : Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit as Retrofit
        }
    }



    interface Services {

        @POST("/api/balanceinvestment/getBalanceActual")
        fun getBalanceInvestiments(@Body user: User?) : Call<List<BalanceInvestiment>>

    }

}