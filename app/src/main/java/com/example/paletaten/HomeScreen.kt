package com.example.paletaten

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onCardClicked: (Pokemon) -> Unit,
    onItemSelected: (PokemonType)-> Unit,
    type: String,
    pokemonViewModel: PokemonViewModel = viewModel()
) {

    //val pokemonList = pokemonViewModel.state.value

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.pokemon_logo),
                contentDescription = stringResource(R.string.pokemon_logo_name),
                modifier = modifier
                    .fillMaxWidth(0.6f)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(18.dp))
            SearchBar(viewModel = pokemonViewModel)
            Spacer(modifier = Modifier.height(24.dp))
            TypeRadioButton(type,onItemSelected)
            Spacer(modifier = Modifier.height(24.dp))
            PokemonList(viewModel = pokemonViewModel, onCardClicked = onCardClicked)

            }
        }
    }

@Composable
private fun PokemonList(
    //pokemonList: List<Pokemon>,
    onCardClicked: (Pokemon) -> Unit,
    viewModel: PokemonViewModel
) {
    val pokemonList = viewModel.state.value


    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        if (!pokemonList.isNullOrEmpty()) {
            items(pokemonList) {
                PokemonCard(
                    pokemon = it.copy(),
                    onCardClicked = onCardClicked
                )
            }
        }
    }
}
