package com.example.kotlindictionary

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView
import me.jackdevey.codeview.CodeView

class ItemActivity : AppCompatActivity() {

    var link : String? = null

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        actionBar.setTitle(intent.getStringExtra("iIop"))

        //get content
        findViewById<TextView>(R.id.a_title).text = intent.getStringExtra("iTitle")
        findViewById<TextView>(R.id.a_description).text = intent.getStringExtra("iDescription")
        findViewById<SubsamplingScaleImageView>(R.id.a_image).setImage(ImageSource.resource(intent.getIntExtra("iImageView", R.drawable.k_letter_ground)))

        findViewById<CodeView>(R.id.code_view).code = "fun main() {\n" +
                "    fun printDouble(d: Double) { print(d) }\n" +
                "\n" +
                "    val i = 1\n" +
                "    val d = 1.0\n" +
                "    val f = 1.0f\n" +
                "\n" +
                "    printDouble(d)\n" +
                "//    printDouble(i) // Error: Type mismatch\n" +
                "//    printDouble(f) // Error: Type mismatch\n" +
                "}"
        findViewById<CodeView>(R.id.code_view).show()


        link = intent.getStringExtra("iLink")
    }

    //action for activity_item.linkBtn
    fun getLink (view: View) {

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(link)
        startActivity(intent)
    }
}