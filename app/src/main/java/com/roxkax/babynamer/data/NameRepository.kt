package com.roxkax.babynamer.data

import com.roxkax.babynamer.data.interfaces.INameProvider
import com.roxkax.babynamer.data.models.BabyName
import javax.inject.Inject

class NameRepository @Inject constructor(private val providers: Set<@JvmSuppressWildcards INameProvider>) {

    suspend fun getNames(): List<BabyName> = providers.map { it.getListOfNames() }.flatten().distinct()
}