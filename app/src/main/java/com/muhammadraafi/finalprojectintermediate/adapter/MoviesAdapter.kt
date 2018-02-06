package com.muhammadraafi.finalprojectintermediate.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.muhammadraafi.finalprojectintermediate.R
import com.muhammadraafi.finalprojectintermediate.model.Movie

/**
 * Created by uty1 on 03/02/2018.
 */
class MoviesAdapter(private val listMovie:List<Movie>): RecyclerView.Adapter<MoviesAdapter.Holder>() {
    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view:View = LayoutInflater.from(parent?.context).inflate(R.layout.movie_card,parent,false)
        return Holder(view)
    }

    inner class Holder(val view:View):RecyclerView.ViewHolder(view){
        fun bind(position: Int){
            val newList = listMovie[position]
            Glide.with(view.context).load("https://image.tmdb.org/t/p/w185${newList.poster_path}")
        }
    }
}