package org.sopt.soptweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.sopt.soptweather.databinding.ActivityCityDetailBinding
import org.sopt.soptweather.databinding.ActivityMainBinding

class CityDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra("id")
        //상세뷰..
    }
}