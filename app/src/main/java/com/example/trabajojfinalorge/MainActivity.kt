package com.example.trabajojfinalorge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.content.Intent
import android.widget.Toast
import com.example.trabajojfinalorge.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView2.setOnClickListener() {
            val intent=Intent(this, RestableceContra::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener() {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(binding.editTextTextEmailAddress.text.toString(),binding.editTextNumberPassword.text.toString()).addOnCompleteListener(){
                if (it.isSuccessful){
                    val intent=Intent(this, Inicio::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}