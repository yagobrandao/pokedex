package com.yagobrandao.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pokemons = mutableListOf<Pokemon>(
        Pokemon("Bulbassaur" , "Seed" , "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"),
        Pokemon("Charmander" , "Fire" , "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png"),
        Pokemon("Squirtle" , "Water" , "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png"),
        Pokemon("Caterpie" , "Bug" , "https://assets.pokemon.com/assets/cms2/img/pokedex/full/010.png"),
        Pokemon("Pidgey" , "Normal" , "https://assets.pokemon.com/assets/cms2/img/pokedex/full/016.png")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureRecyclerView()
    }

    fun configureRecyclerView() {
        recyclerView_pokemons?.adapter = PokemonAdapter(pokemons , context = this@MainActivity)
        recyclerView_pokemons?.layoutManager = LinearLayoutManager(recyclerView_pokemons.context!!)
        recyclerView_pokemons?.itemAnimator = DefaultItemAnimator()
        recyclerView_pokemons?.addItemDecoration(
            DividerItemDecoration(
                recyclerView_pokemons.context!!,
                LinearLayoutManager(recyclerView_pokemons.context!!)?.orientation
            )
        )
    }

}