package com.roxkax.babynamer.ui.detail

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roxkax.babynamer.data.NameRepository
import com.roxkax.babynamer.data.models.GenderEnum
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NameDetailViewModel @Inject constructor(private val nameRepository : NameRepository) : ViewModel() {

    val gender = MutableLiveData<GenderEnum>()

    fun loadData(intent: Intent){
        val listOfNames = nameRepository.getNames()
        gender.value = GenderEnum.fromInt(intent.extras?.getInt(GenderEnum::name.name))
    }
}