package com.example.calculatorapp.ui

import android.content.Context
import android.icu.text.DecimalFormat
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.example.calculatorapp.R
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception

class MainViewModel : ViewModel() {

    fun addToCountText(tvCount: TextView, value: String): String {
        return "${tvCount.text}$value"
    }

    fun getExpression(tvCount: TextView): String {
        val expression = tvCount.text.replace(Regex("x"), "*")
        return expression
    }

    fun showResult(tvResult: TextView, tvCount: TextView, context: Context) {
        try {
            val expression = getExpression(tvCount)
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                tvResult.text = "Error"
                tvResult.setTextColor(ContextCompat.getColor(context, R.color.red))
            } else {
                // Show Result
                tvResult.text = DecimalFormat("0.######").format(result).toString()
                tvResult.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.btn_background2
                    )
                )
            }
        } catch (e: Exception) {
            // Show Error Message
            tvResult.text = "Error"
            tvResult.setTextColor(ContextCompat.getColor(context, R.color.red))
        }
    }

}