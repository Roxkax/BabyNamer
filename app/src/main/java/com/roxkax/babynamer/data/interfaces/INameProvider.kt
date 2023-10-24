package com.roxkax.babynamer.data.interfaces

import com.roxkax.babynamer.data.models.BabyName

interface INameProvider {
    fun getListOfNames() : List<BabyName>
}