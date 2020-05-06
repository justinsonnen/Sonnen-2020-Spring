package com.example.beernear.model

class Beers() {
    var breweryName: String? = null
    var beerName: String? = null
    var beerLook: String? = null
    var beerSmell: String? = null
    var beerTaste: String? = null
    var id: Int? = null

    constructor(breweryName: String,
                beerName: String, beerLook: String,
                beerSmell: String, beerTaste: String,
                id: Int): this(){
        this.breweryName = breweryName
        this.beerName = beerName
        this.beerLook = beerLook
        this.beerSmell = beerSmell
        this.beerTaste = beerTaste
        this.id = id
    }
}