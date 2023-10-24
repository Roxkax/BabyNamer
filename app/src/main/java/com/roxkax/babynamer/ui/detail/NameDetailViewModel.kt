package com.roxkax.babynamer.ui.detail

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.roxkax.babynamer.data.GenderEnum
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NameDetailViewModel @Inject constructor() : ViewModel() {

    val gender = MutableLiveData<GenderEnum>()

    fun loadData(intent: Intent){
        gender.value = GenderEnum.fromInt(intent.extras?.getInt(GenderEnum::name.name))
    }
}