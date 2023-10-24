package com.roxkax.babynamer.services

import com.roxkax.babynamer.data.interfaces.INameProvider
import com.roxkax.babynamer.data.models.BabyName
import com.roxkax.babynamer.data.models.GenderEnum

class ApiNameProvider : INameProvider {
    override fun getListOfNames(): List<BabyName> = listOf(BabyName("2016", GenderEnum.FEMALE, "ASIAN AND PACIFIC ISLANDER", "Olivia", "172", "1"))
}