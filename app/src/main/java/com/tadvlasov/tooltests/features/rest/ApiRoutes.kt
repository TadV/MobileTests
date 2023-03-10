package com.tadvlasov.tooltests.features.rest

import com.tadvlasov.tooltests.features.rest.requestModels.AuthRQ
import com.tadvlasov.tooltests.features.rest.responseModels.UserRS
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiRoutes {
    @POST("sanki.php?delay=5")
    fun auth(@Body dataModel: AuthRQ?): Call<UserRS?>?
}