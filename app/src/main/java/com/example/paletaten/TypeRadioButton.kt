package com.example.paletaten

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


//@Preview(showBackground = true)
@Composable
fun TypeRadioButton(type:String, onItemSelected:(PokemonType)-> Unit) {


    Column {
        Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            RadioButton(selected = type == PokemonType.ELECTRIC.toString() , onClick = { onItemSelected(PokemonType.ELECTRIC) })
            Text(text = PokemonType.ELECTRIC.toString())
        }
        Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            RadioButton(selected = type == PokemonType.GRASS.toString(), onClick = { onItemSelected(PokemonType.GRASS)})
            Text(text = PokemonType.GRASS.toString())
        }
        Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            RadioButton(selected = type == PokemonType.WATER.toString(), onClick = { onItemSelected(PokemonType.WATER)})
            Text(text = PokemonType.WATER.toString())
        }
        Row (Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            RadioButton(selected = type == PokemonType.NINGUNO.toString(), onClick = { onItemSelected(PokemonType.NINGUNO)})
            Text(text = PokemonType.NINGUNO.toString())
        }
    }
}