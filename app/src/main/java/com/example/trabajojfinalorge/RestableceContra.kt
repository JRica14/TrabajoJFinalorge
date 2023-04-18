package com.example.trabajojfinalorge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.trabajojfinalorge.databinding.ActivityRestableceContraBinding
import com.google.firebase.auth.FirebaseAuth

class RestableceContra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRestableceContraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener() {
            FirebaseAuth.getInstance().sendPasswordResetEmail(binding.editTextTextEmailAddress.text.toString())
            Toast.makeText(this, "Correo enviado para el cambio de contraseña", Toast.LENGTH_SHORT).show()
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}