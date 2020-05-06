package com.example.beernear.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.beernear.model.*

class BeersDatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {

        var CREATE_BEERS_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_BREWERY_NAME + " TEXT," +
                KEY_BEER_NAME + " TEXT, " +
                KEY_BEER_LOOK + " TEXT, " +
                KEY_BEER_SMELL + " TEXT, " +
                KEY_BEER_TASTE + " TEXT " + ")"

        db!!.execSQL(CREATE_BEERS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun createBeer(beer: Beers){
        var db: SQLiteDatabase = writableDatabase
        var values: ContentValues = ContentValues()
        values.put(KEY_BREWERY_NAME, beer.breweryName)
        values.put(KEY_BEER_NAME, beer.beerName)
        values.put(KEY_BEER_LOOK, beer.beerLook)
        values.put(KEY_BEER_SMELL, beer.beerSmell)
        values.put(KEY_BEER_TASTE, beer.beerTaste)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readBeers(): ArrayList<Beers> {
        var db: SQLiteDatabase = readableDatabase
        var list: ArrayList<Beers> = ArrayList()
        var selectAll = "SELECT * FROM " + TABLE_NAME
        var cursor: Cursor = db.rawQuery(selectAll, null)

        if (cursor.moveToFirst()) {
            do {
                var beer = Beers()
                beer.id = cursor.getInt(cursor.getColumnIndex(KEY_ID))
                beer.breweryName = cursor.getString(cursor.getColumnIndex(KEY_BREWERY_NAME))
                beer.beerName = cursor.getString(cursor.getColumnIndex(KEY_BEER_NAME))
                beer.beerLook = cursor.getString(cursor.getColumnIndex(KEY_BEER_LOOK))
                beer.beerSmell = cursor.getString(cursor.getColumnIndex(KEY_BEER_SMELL))
                beer.beerTaste = cursor.getString(cursor.getColumnIndex(KEY_BEER_TASTE))
                list.add(beer)

            }while (cursor.moveToNext())
        }
        return list
    }

    fun deleteBeer(id: Int) {
        var db: SQLiteDatabase = writableDatabase
        db.delete(TABLE_NAME, KEY_ID + "=?", arrayOf(id.toString()))
        db.close()
    }
}