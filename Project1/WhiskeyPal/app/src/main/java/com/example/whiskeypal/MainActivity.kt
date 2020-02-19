package com.example.whiskeypal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity(), View.OnClickListener {
    val REQUEST_CODE = 1

    override fun onClick(v: View?) {
        when(v!!.id){
            pappyId.id -> {
                var pappyIntent = Intent(
                    this,
                    BiosActivity::class.java
                )
                pappyIntent.putExtra("bottle", "pappy")
                startActivityForResult(pappyIntent, REQUEST_CODE)
            }
            staggId.id -> {
                var staggIntent = Intent(
                    this,
                    BiosActivity::class.java
                )
                staggIntent.putExtra("bottle", "stagg")
                startActivityForResult(staggIntent, REQUEST_CODE)
            }
            georgeId.id -> {
                var georgeIntent = Intent(
                    this,
                    BiosActivity::class.java
                )
                georgeIntent.putExtra("bottle", "george")
                startActivityForResult(georgeIntent, REQUEST_CODE)
            }
            williamId.id -> {
                var williamIntent = Intent(
                    this,
                    BiosActivity::class.java
                )
                williamIntent.putExtra("bottle", "william")
                startActivityForResult(williamIntent, REQUEST_CODE)
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pappy = pappyId
        var stagg = staggId
        var george = georgeId
        var william = williamId


        //  Class level OnClicklistener so have to register views to receive events
        pappy.setOnClickListener(this)
        stagg.setOnClickListener(this)
        george.setOnClickListener(this)
        william.setOnClickListener(this)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                var result = data!!.extras.get("return").toString()

                Toast.makeText(this, result, Toast.LENGTH_LONG).show()
            }
        }

    }


}
