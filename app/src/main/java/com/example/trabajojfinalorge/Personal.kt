package com.example.trabajojfinalorge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabajojfinalorge.databinding.ActivityPersonalBinding

class Personal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPersonalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inicio.setOnClickListener {
            val intent= Intent(this, Inicio::class.java)
            startActivity(intent)
        }
        binding.formularios.setOnClickListener {
            val intent= Intent(this, Formulario::class.java)
            startActivity(intent)
        }
    }
}