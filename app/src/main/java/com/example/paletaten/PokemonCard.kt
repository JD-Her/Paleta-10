package com.example.paletaten

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.paletaten.ui.theme.PaletaTenTheme

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
    onCardClicked: (Pokemon) -> Unit
) {
    Card(
        modifier = modifier.clickable {
            onCardClicked.invoke(pokemon)
        },
        elevation = 8.dp,
        shape = RoundedCornerShape(24.dp)
    ) {
        Column {
            Thumb(thumb = pokemon.thumb)
            PokemonName(name = pokemon.name)

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PokemonCardPreview() {
//    PaletaTenTheme {
//        PokemonCard()
//    }
//}

@Composable
private fun PokemonName(
    name: String,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.background(MaterialTheme.colors.onBackground)
            .padding(8.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun Thumb(thumb: String) {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = thumb,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colors.background,
                            Color.Transparent
                        )
                    )
                ),
            contentScale = ContentScale.Crop
        )
    }
}