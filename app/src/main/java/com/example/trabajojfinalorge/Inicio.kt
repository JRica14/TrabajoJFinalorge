package com.example.trabajojfinalorge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabajojfinalorge.databinding.ActivityInicioBinding


class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.formularios.setOnClickListener {
            val intent= Intent(this, Formulario::class.java)
            startActivity(intent)
        }
        binding.personal.setOnClickListener {
            val intent= Intent(this, Personal::class.java)
            startActivity(intent)
        }
    }
}