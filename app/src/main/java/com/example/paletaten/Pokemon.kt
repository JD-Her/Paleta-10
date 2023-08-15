package com.example.paletaten

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val thumb: String,
    val speciality: String,
    val pokemonType: PokemonType,
    val attack: String,
    val defense: String
): Parcelable

