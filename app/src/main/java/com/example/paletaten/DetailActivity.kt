package com.example.paletaten

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.paletaten.ui.theme.PaletaTenTheme

class DetailActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaletaTenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val pokemonInf = intent.getParcelableExtra("pokemon_key", Pokemon::class.java)
                    DetailScreen(
                        name = pokemonInf?.name ?: "value",
                        thumb = pokemonInf?.thumb ?: "value",
                        pokemonType = ((pokemonInf?.pokemonType ?: PokemonType.NINGUNO)),
                        speciality = pokemonInf?.speciality ?: "value",
                        attack = pokemonInf?.attack ?: "0",
                        defense = pokemonInf?.defense ?: "0"
                    )
                }
            }
        }
    }
}
