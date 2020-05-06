package com.example.beernear.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beernear.R
import com.example.beernear.R.layout.activity_beer_list
import com.example.beernear.data.BeerListAdapter
import com.example.beernear.data.BeersDatabaseHandler
import com.example.beernear.model.Beers
import kotlinx.android.synthetic.main.activity_beer_list.*

class BeerListActivity : AppCompatActivity() {

    private var adapter: BeerListAdapter? = null
    private var beerList: ArrayList<Beers>? = null
    private var beerListItems: ArrayList<Beers>? =null
    private var layoutManager: RecyclerView.LayoutManager? =null
    var dbHandler: BeersDatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_beer_list)

        dbHandler = BeersDatabaseHandler(this)
        beerList = ArrayList<Beers>()
        beerListItems = ArrayList()
        layoutManager = LinearLayoutManager(this)
        adapter = BeerListAdapter(beerListItems!!, this)

        // list -> recyclerView
        recyclerViewId.layoutManager = layoutManager
        recyclerViewId.adapter = adapter

        //load beers
        beerList = dbHandler!!.readBeers()

        for (b in beerList!!.iterator()){
            val beer = Beers()
            beer.breweryName = b.breweryName
            beer.beerName = b.beerName
            beer.beerLook = "Look:      ${b.beerLook}"
            beer.beerSmell = "Smell:    ${b.beerSmell}"
            beer.beerTaste = "Taste:    ${b.beerTaste}"
            beer.id = b.id
            beerListItems!!.add(beer)
        }

        adapter = BeerListAdapter(beerList!!, this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item!!.itemId == R.id.add_menu_button) {
            startActivity(Intent(this, AddBeerActivity::class.java))
        }

        if (item!!.itemId == R.id.add_fact_button) {
            Toast.makeText(this,"Coming Soon", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}