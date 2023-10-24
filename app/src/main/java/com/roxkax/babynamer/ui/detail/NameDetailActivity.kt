package com.roxkax.babynamer.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.roxkax.babynamer.data.models.BabyName
import com.roxkax.babynamer.databinding.ActivityNameDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NameDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameDetailBinding

    private val viewModel: NameDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadData(intent)

        viewModel.babyName.observe(this, ::onBabyNameChange)

        binding.pickAnotherButton.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun onBabyNameChange(babyName: BabyName?) {
        binding.label.text = babyName?.name.toString()
    }
}