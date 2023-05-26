package com.example.calculatorapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvResult = binding.textViewResult
        val tvCount = binding.textViewCount

        binding.zeroButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "0")
        }
        binding.oneButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "1")
        }
        binding.twoButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "2")
        }
        binding.threeButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "3")
        }
        binding.fourButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "4")
        }
        binding.fiveButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "5")
        }
        binding.sixButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "6")
        }
        binding.sevenButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "7")
        }
        binding.eightButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "8")
        }
        binding.nineButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "9")
        }
        binding.divisionButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "/")
        }
        binding.multiplyButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "x")
        }
        binding.minusButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "-")
        }
        binding.additionButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "+")
        }
        binding.percentageButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, "%")
        }
        binding.dotButton.setOnClickListener {
            tvCount.text = viewModel.addToCountText(tvCount, ".")
        }
        binding.acButton.setOnClickListener {
            tvCount.text = ""
            tvResult.text = ""
        }
        binding.backButton.setOnClickListener {
            tvCount.text = tvCount.text.dropLast(1)
        }
        binding.equalButton.setOnClickListener {
            viewModel.showResult(tvResult, tvCount, this)
        }

    }

}