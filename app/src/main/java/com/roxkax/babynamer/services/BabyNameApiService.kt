package com.roxkax.babynamer.services

import com.roxkax.babynamer.data.models.BabyName
import retrofit2.http.GET
import retrofit2.http.Url

public interface BabyNameApiService {

    @GET(GET_BABY_NAME)
    suspend fun getBabyNames(): List<BabyName>

    companion object {
        const val DEFAULT_URL = "https:\\www.google.pt"
        const val BASE_URL = ""
        const val GET_BABY_NAME = ""
    }
}