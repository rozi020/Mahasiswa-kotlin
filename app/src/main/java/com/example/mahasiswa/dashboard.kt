package com.example.mahasiswa

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        button.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()

            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(this@dashboard,MainActivity::class.java))
            finish()
        }
        data.setOnClickListener{
            startActivity(Intent(this@dashboard,DataMhs::class.java))
            finish()
        }
        tambah.setOnClickListener{
            startActivity(Intent(this@dashboard,InputMhs::class.java))
            finish()
        }
    }
}
