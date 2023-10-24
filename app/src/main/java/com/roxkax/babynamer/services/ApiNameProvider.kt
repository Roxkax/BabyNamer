package com.roxkax.babynamer.services

import com.roxkax.babynamer.data.interfaces.INameProvider
import com.roxkax.babynamer.data.models.BabyName

class ApiNameProvider(private val apiService: BabyNameApiService) : INameProvider {

    override suspend fun getListOfNames(): List<BabyName> =
        if (BabyNameApiService.BASE_URL.isBlank()) emptyList()
        else apiService.getBabyNames()
}