package com.roxkax.babynamer.data.models

data class BabyName (
    val year : String,
    val gender : GenderEnum,
    val ethnicity : String,
    val name : String,
    val nameCounter: String,
    val nameRank : String
)