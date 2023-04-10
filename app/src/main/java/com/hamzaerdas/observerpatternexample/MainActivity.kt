package com.hamzaerdas.observerpatternexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.hamzaerdas.observerpatternexample.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.getTime()
        Toast.makeText(this@MainActivity, mainViewModel.date.value, Toast.LENGTH_LONG).show()

        val timeObserver = Observer<String> {
            binding.timeText.text = it
        }

        mainViewModel.date.observe(this@MainActivity, timeObserver)

        binding.button.setOnClickListener {
            mainViewModel.date.value = Date().toString()
        }
    }
}