package com.example.paletaten

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    viewModel: PokemonViewModel,
    modifier: Modifier = Modifier,
) {
    var query by rememberSaveable { mutableStateOf("") }
 //   var showClearIcon by rememberSaveable { mutableStateOf(false) }

  /*  if (query.isEmpty()) {
        showClearIcon = false
    } else if (query.isNotEmpty()) {
        showClearIcon = true
    }*/

    TextField(
        value = query,
        onValueChange = {  query = it
            viewModel.realizarBusqueda(it)
        },
        maxLines = 1,
        singleLine = true,
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        placeholder = { Text(stringResource(id = R.string.placeholder_search)) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),

        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//        trailingIcon = {
//            IconButton(onClick = { }) {
//                Icon(
//                    imageVector = Icons.Rounded.Clear,
//                    //tint = MaterialTheme.colors.onBackground,
//                    contentDescription = "Clear Icon"
//                )
//            }
//        },
        modifier = modifier
            .heightIn(min = 56.dp)
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth()
            .shadow(5.dp, CircleShape)
            .background(Color.White, CircleShape)
            .padding(horizontal = 20.dp, vertical = 0.dp)
    )
}
