package com.ismailmesutmujde.kotlindetailedrecyclerviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MoviesRecyclerViewAdapter(private val mContext : Context, private val moviesList : List<Movies>) : RecyclerView.Adapter<MoviesRecyclerViewAdapter.CardViewDesignObjectsHolder>() {

    inner class CardViewDesignObjectsHolder(view : View)  : RecyclerView.ViewHolder(view) {
        var imageViewMoviePoster : ImageView
        var textViewMovieTitle : TextView
        var textViewMoviePrice : TextView
        var buttonAddCart : Button

        init {
            imageViewMoviePoster = view.findViewById(R.id.imageViewMoviePoster)
            textViewMovieTitle = view.findViewById(R.id.textViewMovieTitle)
            textViewMoviePrice = view.findViewById(R.id.textViewMoviePrice)
            buttonAddCart = view.findViewById(R.id.buttonAddCart)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewDesignObjectsHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_movie_design, parent, false)
        return CardViewDesignObjectsHolder(design)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: CardViewDesignObjectsHolder, position: Int) {
        val movie = moviesList[position]
        holder.textViewMovieTitle.text = movie.movieName
        holder.textViewMoviePrice.text = "${movie.moviePrice} TL"

        holder.imageViewMoviePoster.setImageResource(mContext.resources.getIdentifier(movie.moviePosterName,"drawable", mContext.packageName))

        holder.buttonAddCart.setOnClickListener {
            Toast.makeText(mContext, "${movie.movieName} movie added to cart", Toast.LENGTH_SHORT).show()
        }
    }
}