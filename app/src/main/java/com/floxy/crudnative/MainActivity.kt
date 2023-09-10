package com.floxy.crudnative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.floxy.crudnative.viewmodel.QuotesViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesVM = ViewModelProvider(this).get(QuotesViewModel::class.java)
        val textTrigger: TextView = findViewById(R.id.text_data)
        val textCreator: TextView = findViewById(R.id.text_creator)
        val buttonTrigger: Button = findViewById(R.id.btn_generate)

        buttonTrigger.setOnClickListener {
            textTrigger.text = ""
            textCreator.text = ""
            quotesVM.fetchQuotes()
            quotesVM.myResponse.observe(this, Observer {
                textTrigger.text = "' ${it[0].quote} '"
                textCreator.text = "- ${it[0].author}"
            })
        }
    }
}