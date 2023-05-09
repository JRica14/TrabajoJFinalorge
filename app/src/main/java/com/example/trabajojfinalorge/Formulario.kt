package com.example.trabajojfinalorge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trabajojfinalorge.databinding.ActivityFormularioBinding
import com.google.firebase.firestore.FirebaseFirestore


class Formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = FirebaseFirestore.getInstance()
        val ejer = db.collection("Ejercicios")

        binding.inicio.setOnClickListener {
            val intent= Intent(this, Inicio::class.java)
            startActivity(intent)
        }
        binding.personal.setOnClickListener {
            val intent= Intent(this, Personal::class.java)
            startActivity(intent)
        }

        /*
        ejer.whereEqualTo("Tipo","Luxación").get().addOnSuccessListener {
            for(documentos in it){
                documentos['Ubicación']
            }
        }
        */
    }
}