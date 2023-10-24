package com.roxkax.babynamer.data


enum class GenderEnum(val value: Int) {
    MALE(0),
    FEMALE(1);

    companion object {
        private val map = GenderEnum.values().associateBy(GenderEnum::value)
        fun fromInt(value: Int?) = map[value]
    }
}