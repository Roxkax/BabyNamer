package com.roxkax.babynamer.ui.detail

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roxkax.babynamer.data.NameRepository
import com.roxkax.babynamer.data.models.BabyName
import com.roxkax.babynamer.data.models.GenderEnum
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Date
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

@HiltViewModel
class NameDetailViewModel @Inject constructor(private val nameRepository: NameRepository) :
    ViewModel() {

    val babyName = MutableLiveData<BabyName>()

    fun loadData(intent: Intent) =
        viewModelScope.launch {
            val listOfNames = nameRepository.getNames().filter {
                it.gender == GenderEnum.fromInt(intent.extras?.getInt(GenderEnum::name.name))
            }
            listOfNames[Random(System.currentTimeMillis()).nextInt(listOfNames.indices)].also { babyName.value = it }
        }

}