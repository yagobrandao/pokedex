package com.yagobrandao.pokedex


import android.R.attr.data
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso


class PokemonAdapter(pokemonList: List<Pokemon> , context : Context) :
    RecyclerView.Adapter<PokemonAdapter.PokeViewHolder>() {

    private val pokemonList: List<Pokemon>
    private val context : Context

    inner class PokeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var type: TextView
        var ivPokemon: ImageView

        init {
            name = itemView.findViewById<View>(R.id.tv_name) as TextView
            type = itemView.findViewById<View>(R.id.tv_type) as TextView
            ivPokemon =
                itemView.findViewById<View>(R.id.iv_pokemon) as ImageView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView: View = inflater.inflate(R.layout.pokemon_row, parent, false)
        return PokeViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: PokeViewHolder,
        position: Int
    ) {
        val pokemon: Pokemon = pokemonList[position]
        holder.name.setText(pokemon.name)
        holder.type.setText(pokemon.type)
        Picasso.with(context)
            .load(pokemon.imageURL)
            .memoryPolicy(MemoryPolicy.NO_CACHE )
            .networkPolicy(NetworkPolicy.NO_CACHE)
            .noFade()
            .into(holder.ivPokemon)
        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Nome: ${pokemon.name} - Tipo: ${pokemon.type}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    init {
        this.pokemonList = pokemonList
        this.context = context
    }
}