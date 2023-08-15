package com.example.paletaten

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.paletaten.ui.theme.PaletaTenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaletaTenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var selected by remember {
                        mutableStateOf("Jd")
                    }
                    HomeScreen(
                        onCardClicked = ::onCardClicked,
                        pokemonViewModel = PokemonViewModel(),
                        type = selected,
                        onItemSelected = { selected = it.toString() }
                    )
                }
            }
        }
    }

    fun onCardClicked(pokemon: Pokemon) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)

        intent.putExtra("pokemon_key", pokemon)
        startActivity(intent)
    }
}
