package com.example.paletaten

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PokemonViewModel : ViewModel() {

    private var _Lista: MutableState<List<Pokemon>> = mutableStateOf(emptyList())
    val state: State<List<Pokemon>>
        get() = _Lista


    init {
        _Lista.value = listOf(
            Pokemon(
                name = "Pikachu",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
                speciality = "Cola de rayo",
                pokemonType = PokemonType.ELECTRIC,
                attack = "80",
                defense = "70"
            ),
            Pokemon(
                name = "Monkey",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/56.png",
                speciality = "Kick",
                pokemonType = PokemonType.GRASS,
                attack = "78",
                defense = "60"
            ),
            Pokemon(
                name = "Mewtwo",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png",
                speciality = "Control",
                pokemonType = PokemonType.WATER,
                attack = "100",
                defense = "99"
            ),
            Pokemon(
                name = "Dratini",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/148.png",
                speciality = "Aguaso",
                pokemonType = PokemonType.ELECTRIC,
                attack = "78",
                defense = "60"
            ),
            Pokemon(
                name = "Squirtle",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
                speciality = "Torrente",
                pokemonType = PokemonType.GRASS,
                attack = "60",
                defense = "67"
            ),
            Pokemon(
                name = "Pidgeot",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png",
                speciality = "Vista Lince",
                pokemonType = PokemonType.WATER,
                attack = "70",
                defense = "70"
            ),
            Pokemon(
                name = "Nidoran",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/32.png",
                speciality = "Poison",
                pokemonType = PokemonType.ELECTRIC,
                attack = "40",
                defense = "40"
            ),
            Pokemon(
                name = "Oddish",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/43.png",
                speciality = "Hierba",
                pokemonType = PokemonType.GRASS,
                attack = "30",
                defense = "40"
            ),
            Pokemon(
                name = "Golduck",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/55.png",
                speciality = "Humidity",
                pokemonType = PokemonType.WATER,
                attack = "60",
                defense = "70"
            ),
            Pokemon(
                name = "Gastly",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/92.png",
                speciality = "Levitation",
                pokemonType = PokemonType.ELECTRIC,
                attack = "40",
                defense = "30"
            )
        )
    }

// Crear una funcion que retorne una lista de pokemon:

    fun pokemonListData(): List<Pokemon> {
        val lisPokemon = listOf(
            Pokemon(
                name = "Pikachu",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
                speciality = "Cola de rayo",
                pokemonType = PokemonType.ELECTRIC,
                attack = "80",
                defense = "70"
            ),
            Pokemon(
                name = "Monkey",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/56.png",
                speciality = "Kick",
                pokemonType = PokemonType.GRASS,
                attack = "78",
                defense = "60"
            ),
            Pokemon(
                name = "Mewtwo",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png",
                speciality = "Control",
                pokemonType = PokemonType.WATER,
                attack = "100",
                defense = "99"
            ),
            Pokemon(
                name = "Dratini",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/148.png",
                speciality = "Aguaso",
                pokemonType = PokemonType.ELECTRIC,
                attack = "78",
                defense = "60"
            ),
            Pokemon(
                name = "Squirtle",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
                speciality = "Torrente",
                pokemonType = PokemonType.GRASS,
                attack = "60",
                defense = "67"
            ),
            Pokemon(
                name = "Pidgeot",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/18.png",
                speciality = "Vista Lince",
                pokemonType = PokemonType.WATER,
                attack = "70",
                defense = "70"
            ),
            Pokemon(
                name = "Nidoran",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/32.png",
                speciality = "Poison",
                pokemonType = PokemonType.ELECTRIC,
                attack = "40",
                defense = "40"
            ),
            Pokemon(
                name = "Oddish",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/43.png",
                speciality = "Hierba",
                pokemonType = PokemonType.GRASS,
                attack = "30",
                defense = "40"
            ),
            Pokemon(
                name = "Golduck",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/55.png",
                speciality = "Humidity",
                pokemonType = PokemonType.WATER,
                attack = "60",
                defense = "70"
            ),
            Pokemon(
                name = "Gastly",
                thumb = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/92.png",
                speciality = "Levitation",
                pokemonType = PokemonType.ELECTRIC,
                attack = "40",
                defense = "30"
            )
        )
        val pokemonList = ArrayList<Pokemon>()
        lisPokemon.forEach { pokemonIterado ->
            pokemonList.add(
                Pokemon(
                    pokemonIterado.name,
                    pokemonIterado.thumb,
                    pokemonIterado.speciality,
                    pokemonIterado.pokemonType,
                    pokemonIterado.attack,
                    pokemonIterado.defense
                )
            )
        }
        return pokemonList
    }
    fun realizarBusqueda(query: String) {
        val allPokemonList = pokemonListData()

        //Nuevo Array list que va a contener la lista filtrada con la consulta(query)
        val filteredList = ArrayList<Pokemon>()
        if(query.isEmpty()){
            _Lista.value = allPokemonList
        }else{
            //Bucle en los datos dentro de cada pokemon para leer el nombre del pokemon.
            allPokemonList.forEach { pokemon ->
                // Compara la consulta con el nombre de los pokemons para encontrar el match.
                if (pokemon.name.lowercase().contains(query.lowercase())) {
                    //si el match es encontrado, agrega el nombre a la lista filtrada.
                    filteredList.add(pokemon)
//                    Pokemon(
//                        pokemon.name,
//                        pokemon.thumb,
//                        pokemon.speciality,
//                        pokemon.pokemonType,
//                        pokemon.attack,
//                        pokemon.defense
//                    )
                    // )
                }
            }
            _Lista.value = filteredList
        }
    }
}


//    fun performPokemonNameFilter(
//        pokemonNameFilter: String
//    ){
//        val filteredList = listOf<Pokemon>()
//        val results = state.pokemon1.filter {
//            it.name.contains(pokemonNameFilter.trim(),ignoreCase = true)
//        }
//        }


//    fun pokemonListData(poke: Pokemon){
//        val index = state.
//    }
