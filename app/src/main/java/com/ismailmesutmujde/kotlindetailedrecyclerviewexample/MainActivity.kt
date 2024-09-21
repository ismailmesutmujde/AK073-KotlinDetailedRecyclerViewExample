package com.ismailmesutmujde.kotlindetailedrecyclerviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ismailmesutmujde.kotlindetailedrecyclerviewexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain : ActivityMainBinding
    private lateinit var moviesList : ArrayList<Movies>
    private lateinit var recyclerViewAdapter: MoviesRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMain.root
        setContentView(view)

        bindingMain.recyclerView.setHasFixedSize(true)
        bindingMain.recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val m1 = Movies(1,"Django","django", 12.99)
        val m2 = Movies(2,"Inception","inception", 10.99)
        val m3 = Movies(3,"Interstellar","interstellar", 17.99)
        val m4 = Movies(4,"The Hateful Eight","thehatefuleight", 5.99)
        val m5 = Movies(5,"The Pianist","thepianist", 23.99)
        val m6 = Movies(6,"Bir Zamanlar Anadolu'da","birzamanlaranadoluda", 2.99)

        moviesList = ArrayList<Movies>()
        moviesList.add(m1)
        moviesList.add(m2)
        moviesList.add(m3)
        moviesList.add(m4)
        moviesList.add(m5)
        moviesList.add(m6)

        recyclerViewAdapter = MoviesRecyclerViewAdapter(this, moviesList)
        bindingMain.recyclerView.adapter = recyclerViewAdapter


    }
}