package com.example.whiskeypal

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_bios.*

class BiosActivity : AppCompatActivity() {

    val pappyInfo = "\"Sweet and spicy notes of cinnamon, raisins, brownies, vanilla, oak, and maple are found on the nose. Honey, vanilla toffee, nuts, dark fruits, and baked apple pie greet you on the palate. Finish is LONG with plenty of spice and more baked apple pie drizzled with vanilla-laced honey.\" - Distiller.com"
    val staggInfo = "\"Stagg Jr. Barrel Proof Bourbon Batch 13 from Buffalo Trace is bottled at 128.4 proof. The bourbon is uncut and unfiltered, and is matured for eight years. It's intended to have a similar profile to the popular George T. Stagg, and is released in batches twice per year. Batch 13 was announced in January 2020 and the 14th batch is expected in late spring/early summer of 2020. Stagg Jr. was first introduced in 2013.\" - Distiller.com"
    val georgeInfo = "\"A nose full of heat, but once subsided, we find cherries, chocolate, tobacco and brown sugar. On the palate, notes combine into chocolate covered cherries, dipped in honey. The finish is long with even more chocolate, mixed with coffee and a cherry [syrup] on top.\" - Distiller.com"
    val williamInfo = "\"As you taste this bourbon you may be reminded of the dessert scene in \"Young Frankenstein\" when Igor is accused of making \"yummy sounds.\" Vanilla, milk chocolate, almond and Bing cherries waft from the glass and onto the palate. Comforting, buttery shortbread, honeysuckle and the most delicate acidity of lemon oil follow. Given its considerable proof, it's hardly noticeable, perhaps distracted by its truly yummy and balanced flavors. Mmmmmmmm.\" - Distiller.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bios)


                var bottle = intent.extras
        if (bottle != null){
            if(bottle.get("bottle") == "pappy"){

                biosImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.pappy, null))
                biosText.text = pappyInfo

            }
            else
                if(bottle.get("bottle") == "stagg"){
                    biosImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.staggjr, null))
                    biosText.text = staggInfo
                }else
                    if(bottle.get("bottle") == "george"){
                        biosImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.george, null))
                        biosText.text = georgeInfo
                    }else{
                            biosImageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.william, null))
                            biosText.text = williamInfo
                    }

        }

        goBackButton.setOnClickListener{
            val returnIntent = this.intent
            if(bottle.get("bottle") == "pappy"){
            returnIntent.putExtra("return", "If you like Pappy, check out the others!")}
            else
                if(bottle.get("bottle") == "stagg"){
                    returnIntent.putExtra("return", "If you like StaggJr, check out the others!")}
                    else
                      if(bottle.get("bottle") == "george"){
                        returnIntent.putExtra("return", "If you like G.T.S., check out the others!")}
                       else {
                          returnIntent.putExtra("return", "If you like W.L.Weller, check out the others!")
                      }
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }


    }
}
