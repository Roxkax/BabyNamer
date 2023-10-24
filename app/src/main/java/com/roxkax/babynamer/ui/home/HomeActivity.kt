package com.roxkax.babynamer.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.roxkax.babynamer.data.GenderEnum
import com.roxkax.babynamer.databinding.ActivityHomeBinding
import com.roxkax.babynamer.ui.detail.NameDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.maleButton.setOnClickListener { navigateToDetail(GenderEnum.MALE) }
        binding.femaleButton.setOnClickListener { navigateToDetail(GenderEnum.FEMALE) }
    }

    private fun navigateToDetail(gender: GenderEnum) {
        val intent = Intent(this, NameDetailActivity::class.java)
        intent.putExtra(GenderEnum::name.name, gender.value)
        startActivity(intent)
    }
}