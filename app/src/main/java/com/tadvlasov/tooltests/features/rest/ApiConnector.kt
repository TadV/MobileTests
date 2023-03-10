package com.tadvlasov.tooltests.features.rest

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.tadvlasov.tooltests.features.rest.requestModels.AuthRQ
import com.tadvlasov.tooltests.features.rest.responseModels.UserRS
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnector {
    private val baseApiUrl: String = "https://www.avtsport.ru/"

    private fun testConnection() {
        // on below line we are creating a retrofit
        // builder and passing our base url
        val retrofit = Retrofit.Builder()
            .baseUrl(baseApiUrl)
            // as we are sending data in json format so
            // we have to add Gson converter factory
            .addConverterFactory(GsonConverterFactory.create())
            // at last we are building our retrofit builder.
            .build()
        // below the line is to create an instance for our retrofit api class.
        val retrofitAPI = retrofit.create(ApiRoutes::class.java)
        // passing data from our text fields to our model class.
        val dataModel = AuthRQ("nata6group@ya.ru", "gbyudby789")
        // calling a method to create an update and passing our model class.
        val call: Call<UserRS?>? = retrofitAPI.auth(dataModel)
        var result: String
        Log.d("POST data",dataModel.toString())
        // on below line we are executing our method.
        call!!.enqueue(object : Callback<UserRS?> {
            override fun onResponse(call: Call<UserRS?>, response: Response<UserRS?>) {
                // this method is called when we get response from our api.
                // we are getting a response from our body and
                // passing it to our model class.

                val model: UserRS? = response.body()
                // on below line we are getting our data from model class
                // and adding it to our string.
                val resp = "Response Code : " + response.code() + "\n"

                var respAdditional = "something wrong"
                if (model?.id != null) respAdditional = ("User: "+ model.fio +"\nID: " + model.id + "\nNS: " + model.ns)
                if (model?.error != null) respAdditional = ("Error code: " + model.error + "\n" + "Message: " + model.message)

                // below line we are setting our string to our response.
                result = resp + respAdditional
                Log.d("POST", model.toString())
                Log.d("POST", result)
            }

            override fun onFailure(call: Call<UserRS?>, t: Throwable) {
                // we get error response from API.
                result = "Error found is : " + t.message
                Log.d("POST", result)
            }
        })
    }

    companion object {
        fun test() {
            ApiConnector().testConnection()
        }
    }
}