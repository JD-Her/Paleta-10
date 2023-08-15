package com.example.paletaten

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    name: String,
    thumb: String,
    pokemonType: Enum<PokemonType>,
    speciality: String,
    attack: String,
    defense: String,
) {
    Box( // Box verde
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFE3F2FD),
                        Color(0xFF2196F3)
                    )
                )
            )
            .fillMaxSize()
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box( // Box blanco, Color DeepOrange: 0xFFFBE9E7
            modifier = modifier
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color.White)
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.7f)

        ) {
            Column(modifier = modifier.offset(0.dp, 60.dp)) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (name != null) {
                        Text(
                            text = name,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 25.sp
                        )
                    }
                }
                Row(
                    modifier = Modifier
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        TripleIcons(topText = pokemonType.toString(), buttonText = attack)
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        TripleIcons(topText = speciality, buttonText = defense)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                //  PokemonBaseStats(pokemonData = PokemonData(10, "Ataque", "Raul"))
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        //verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(50.dp)
                .padding(start = 12.dp)
            //          .clickable { onBackpressed.invoke() }            //Se creo la funcion para regresar con el icon.
        )
        Image(
            painterResource(id = R.drawable.pokeball),
            contentDescription = "pokeball",
            modifier = Modifier.size(230.dp)
        )
    }
    Row(horizontalArrangement = Arrangement.Center) {
        PokemonPicture(modifier = modifier, thumb = thumb)
    }
}

@Composable
fun PokemonPicture(modifier: Modifier, thumb: String) {
    Box(
        modifier = modifier.offset(0.dp, 0.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        AsyncImage(
            model = thumb,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(300.dp)
        )
    }
}

@Composable
fun TripleIcons(
    //se colocaron los nommbres de los parametros lo mas generico posible ex: toptex" para ser utilizados
    // varias veces
    modifier: Modifier = Modifier,
    topText: String,
    buttonText: String,

    ) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(10.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF57C00))
                    .height(35.dp)
            ) {
                Text(
                    text = topText,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = "weight",
            modifier = Modifier
                .size(40.dp)
        )
        Text(
            text = buttonText,
            color = Color.Black,
            fontSize = 18.sp
        )
    }
}