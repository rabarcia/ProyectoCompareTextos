package com.curso.android.app.practica.ejerciciofinal.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.ejerciciofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparadorTextos.observe(this){
            println("Recibimos un nuevo valor de comparadorTextos. $it")

            binding.resultTextView.text = if (it.sonIguales)
                "Los textos son iguales" else "Los textos NO son iguales"
        }

        binding.compareButton.setOnClickListener {
            val text1 = binding.text1EditText.text.toString()
            val text2 = binding.text2EditText.text.toString()
            mainViewModel.compareTextos(text1, text2)

        }
    }
}