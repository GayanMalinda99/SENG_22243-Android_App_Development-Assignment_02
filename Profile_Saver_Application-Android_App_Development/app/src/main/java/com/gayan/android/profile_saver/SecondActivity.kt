package com.pasandevin.android.profile_saver

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pasandevin.android.profile_saver.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedName = sharedPreferences.getString("nameKey", null)
        val savedEmail = sharedPreferences.getString("emailKey", null)
        val savedPhone = sharedPreferences.getString("phoneKey", null)
        val savedBoolean = sharedPreferences.getBoolean("booleanKey", false)
        val booleanString = getLabelForBoolean(savedBoolean)

        binding.textlabelname.setText(savedName)
        binding.textlabelemail.setText(savedEmail)
        binding.textlabelphone.setText(savedPhone)
        binding.textlabeladult.setText(booleanString)

    }

    fun getLabelForBoolean(boolean: Boolean): String {
        if (boolean.equals(true)) {
            return "Adult"
        }
        return "not Adult"
    }
}