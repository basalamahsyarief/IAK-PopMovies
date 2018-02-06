package com.muhammadraafi.finalprojectintermediate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.muhammadraafi.finalprojectintermediate.adapter.MoviesAdapter
import com.muhammadraafi.finalprojectintermediate.api.Client
import com.muhammadraafi.finalprojectintermediate.model.Movie
import com.muhammadraafi.finalprojectintermediate.model.Response
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
class MainActivity : AppCompatActivity() {


    lateinit var adapter:MoviesAdapter
    val listMov = mutableListOf<Movie>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = MoviesAdapter(listMov)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter=adapter
    }
    fun getData(){
        Client.api.getMoviePopuler().enqueue(object : Callback<Response>{
            override fun onFailure(call: Call<Response>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Response>?, response: retrofit2.Response<Response>?) {
                response?.body()?.resultsList?.let {
                    listMov.addAll(it)
                    adapter.notifyDataSetChanged()
                }
            }

        })
    }
}
