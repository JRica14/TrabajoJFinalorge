package com.example.trabajojfinalorge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabajojfinalorge.databinding.ActivityFormularioBinding


class Formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inicio.setOnClickListener {
            val intent= Intent(this, Inicio::class.java)
            startActivity(intent)
        }
        binding.personal.setOnClickListener {
            val intent= Intent(this, Personal::class.java)
            startActivity(intent)
        }

    }
}