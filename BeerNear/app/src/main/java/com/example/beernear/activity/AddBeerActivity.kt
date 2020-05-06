package com.example.beernear.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.beernear.R
import com.example.beernear.data.BeersDatabaseHandler
import com.example.beernear.model.Beers
import kotlinx.android.synthetic.main.activity_add_beer.*

class AddBeerActivity : AppCompatActivity() {
    var dbHandler: BeersDatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_beer)

        dbHandler = BeersDatabaseHandler(this)

        addTheBeerButton.setOnClickListener {

            if (!TextUtils.isEmpty(addBreweryNameId.text.toString())
                && !TextUtils.isEmpty(addBeerNameId.text.toString())
                && !TextUtils.isEmpty(addBeerLookId.text.toString())
                && !TextUtils.isEmpty(addBeerSmellId.text.toString())
                && !TextUtils.isEmpty(addBeerTasteId.text.toString())
            ) {

                var beer = Beers()
                beer.breweryName = addBreweryNameId.text.toString()
                beer.beerName = addBeerNameId.text.toString()
                beer.beerLook = addBeerLookId.text.toString()
                beer.beerSmell = addBeerSmellId.text.toString()
                beer.beerTaste = addBeerTasteId.text.toString()

                saveToDB(beer)

                startActivity(
                    Intent(
                    this,
                    BeerListActivity::class.java)
                )

            } else {
                Toast.makeText(this, "PLZ add info to all fields", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun saveToDB(beers: Beers) {
        dbHandler!!.createBeer(beers)
    }
}
