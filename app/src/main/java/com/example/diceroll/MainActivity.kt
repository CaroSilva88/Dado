package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inicializar la variable que guarda el valor del dado luego de ser lanzado
        val rollButton: Button = findViewById(R.id.button)

        //acciones que se ejecuta al presionar el boton
        rollButton.setOnClickListener {

            //Mensaje de Toast cuando se presiona el boton
            Toast.makeText(this, "Buena Suerte!", Toast.LENGTH_SHORT).show()


            //Texto del boton cuando se hace click
            //rollButton.text = "Lanza Nuevamente"

            lanzarDado()


        }
    }
    /**
     * Funcion para generar un numero aleatorio entre 1 y el numero de caras del dado que se pasa por parametro
     */
    private fun lanzarDado() {
        val dice = Dado(6)
        val dadoLanzar = dice.roll()
        val dadoImagen: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (dadoLanzar){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }
        // Update the ImageView with the correct drawable resource ID
        dadoImagen.setImageResource(drawableResource)

        // Update the content description
        dadoImagen.contentDescription = dadoLanzar.toString()
    }
}

/**
 * Dice with a fixed number of sides.
 */
class Dado(private val numCaras: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numCaras).random()
    }
}