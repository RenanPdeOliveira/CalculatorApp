package com.example.calculatorapp

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.calculatorapp.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.zeroButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("0")
        }
        binding.oneButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("1")
        }
        binding.twoButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("2")
        }
        binding.threeButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("3")
        }
        binding.fourButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("4")
        }
        binding.fiveButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("5")
        }
        binding.sixButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("6")
        }
        binding.sevenButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("7")
        }
        binding.eightButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("8")
        }
        binding.nineButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("9")
        }
        binding.divisionButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("/")
        }
        binding.multiplyButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("x")
        }
        binding.minusButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("-")
        }
        binding.additionButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("+")
        }
        binding.percentageButton.setOnClickListener {
            binding.textViewCount.text = addToCountText("%")
        }
        binding.dotButton.setOnClickListener {
            binding.textViewCount.text = addToCountText(".")
        }
        binding.acButton.setOnClickListener {
            binding.textViewCount.text = ""
            binding.textViewResult.text = ""
        }
        binding.backButton.setOnClickListener {
            binding.textViewCount.text = binding.textViewCount.text.dropLast(1)
        }
        binding.equalButton.setOnClickListener {
            showResult()
        }

    }

    private fun addToCountText(value: String): String {
        return "${binding.textViewCount.text}$value"
    }

    private fun getExpression(): String {
        val expression = binding.textViewCount.text.replace(Regex("x"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getExpression()
            val getExpression = ExpressionBuilder(expression).build()
            val result = getExpression.evaluate()
            if (result.isNaN()) {
                // Show Error Message
                binding.textViewResult.text = "Error"
                binding.textViewResult.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                binding.textViewResult.text = DecimalFormat("0.######").format(result).toString()
                binding.textViewResult.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.btn_background2
                    )
                )
            }
        } catch (e: Exception) {
            // Show Error Message
            binding.textViewResult.text = "Error"
            binding.textViewResult.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

}