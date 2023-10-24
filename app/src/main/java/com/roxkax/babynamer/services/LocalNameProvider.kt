package com.roxkax.babynamer.services

import android.content.Context
import com.roxkax.babynamer.R
import com.roxkax.babynamer.data.interfaces.INameProvider
import com.roxkax.babynamer.data.models.BabyName
import com.roxkax.babynamer.data.models.GenderEnum
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.lang.Exception

class LocalNameProvider(@ApplicationContext private val context: Context) : INameProvider {
    override fun getListOfNames(): List<BabyName> {
        return try {
            val names = loadJsonArray(context)
            names.toBabyNameList()
        } catch (e: JSONException) {
            e.printStackTrace()
            emptyList()
        }
    }


    private fun loadJsonArray(context: Context): JSONArray {
        val inputStream = context.resources.openRawResource(R.raw.names)
        BufferedReader(inputStream.reader()).use {
            return JSONArray(it.readText())
        }
    }
}

private fun JSONArray.toBabyNameList(): List<BabyName> {
    val result = mutableListOf<BabyName>()
    for (i in 0 until this.length()) {
        (this[i] as JSONArray).toBabyName()?.let {
            result.add(it)
        }
    }
    return result
}

private fun JSONArray.toBabyName(): BabyName? {
    return try {
        val year = this[0].toString()
        val gender = GenderEnum.valueOf(this[1].toString())
        val ethnicity = this[2].toString()
        val name = this[3].toString()
        val nameCounter = this[4].toString()
        val nameRank = this[5].toString()
        BabyName(year, gender, ethnicity, name, nameCounter, nameRank)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}