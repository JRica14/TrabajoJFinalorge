package com.example.trabajojfinalorge


import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri

import android.os.Bundle

import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trabajojfinalorge.databinding.ActivityFormularioBinding
import com.google.firebase.firestore.FirebaseFirestore


class Formulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFormularioBinding.inflate(layoutInflater)
        val principio="Buenos Días,\n" +
                "Aquí le dejamos su rutina de rehabilitación. Si tienes alguna duda con su rutina, no dudes en preguntarnos a este mismo correo.\n\n\n"
        var texto=principio
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


        binding.button3.setOnClickListener {
            if(binding.spinner.selectedItem.toString()!="-- No Seleccionado --" && binding.spinner2.selectedItem.toString()!="-- No Seleccionado --") {
                texto = principio
                var numero = 1
                ejer
                    .whereEqualTo("Ubicación", binding.spinner.selectedItem.toString())
                    .whereEqualTo("Tipo", binding.spinner2.selectedItem.toString())
                    .limit(binding.spinner3.selectedItem.toString().toLong())
                    .get()
                    .addOnSuccessListener { result ->
                        for (document in result) {
                            texto += "·Ejercicio $numero\n\n" + "Repeticiones:${document.data["Cantidad"]} \n" + "Imagen:\n${document.data["Imagen"]}" + "\n\n\n\n\n"
                            //binding.textView28.text=binding.textView28.text.toString()+"Ejercicio $numero \n"+"Imagen: "+"${document.data["Imagen"]}\n"+"Repeticiones: "+"${document.data["Cantidad"]}\n\n\n "
                            numero++
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.d(TAG, "Error getting documents: ", exception)
                    }
                Toast.makeText(this, "Datos Recogidos", Toast.LENGTH_LONG).show()
                binding.button2.isEnabled=true
            }else {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_LONG).show()
                binding.button2.isEnabled=false
            }

        }
        binding.button2.setOnClickListener {
            val email=Intent(Intent.ACTION_SEND)
            email.setData(Uri.parse("malito:"))
            email.setType("text/plain");
            email.putExtra(Intent.EXTRA_EMAIL, arrayOf(binding.editTextText.text.toString()))
            email.putExtra(Intent.EXTRA_SUBJECT, "Rutina de ejercicios de Rehabilitación")
            texto+="\nUn cordial saludo, Fisio Retiro.\n"
            email.putExtra(Intent.EXTRA_TEXT, texto)

            try {
                //start email intent
                startActivity(Intent.createChooser(email, "Elige Aplicacion..."))
            }
            catch (e: Exception){
                //if any thing goes wrong for example no email client application or any exception
                //get and show exception message
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            }
        }
    }

}