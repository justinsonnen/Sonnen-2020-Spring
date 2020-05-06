package com.example.beernear.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.beernear.R
import com.example.beernear.data.BeerListAdapter.*
import com.example.beernear.model.Beers
import kotlinx.android.synthetic.main.list_row.view.*

class BeerListAdapter(private val list: ArrayList<Beers>,
                        private val context: Context): RecyclerView.Adapter<BeerListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViews(list[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view, context, list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder (itemView: View, context: Context, list: ArrayList<Beers>): RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var mContext = context
        var mList = list
        var breweryName = itemView.listBreweryName as TextView
        var beerName = itemView.listBeerName as TextView
        var beerLook = itemView.listBeerLook as TextView
        var beerSmell = itemView.listBeerSmell as TextView
        var beerTaste = itemView.listBeerTaste as TextView
        var deleteButton = itemView.listDeleteButton as Button


        fun bindViews(beers: Beers){
            breweryName.text = beers.breweryName
            beerName.text = beers.beerName
            beerLook.text = beers.beerLook
            beerSmell.text = beers.beerSmell
            beerTaste.text = beers.beerTaste
            deleteButton.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            var mPosition: Int = adapterPosition
            var beer = mList[mPosition]

            when(v!!.id){
                deleteButton.id -> {
                    deleteBeer(beer.id!!)
                    mList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
                }
            }
        }

        fun deleteBeer(id: Int) {
            var db: BeersDatabaseHandler = BeersDatabaseHandler(mContext)
            db.deleteBeer(id)
        }
    }
}