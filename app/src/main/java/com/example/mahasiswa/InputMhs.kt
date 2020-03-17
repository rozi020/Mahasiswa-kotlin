package com.example.mahasiswa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_input_mhs.*
import org.json.JSONArray

class InputMhs : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_mhs)

        kembali.setOnClickListener{
            startActivity(Intent(this@InputMhs,dashboard::class.java))
            finish()
        }
        insert.setOnClickListener{
            var data_namamhs :String = data1.text.toString()
            var data_nomermhs :String = data2.text.toString()
            var data_alamatmhs :String = data3.text.toString()
            postkeserver(data_namamhs, data_nomermhs, data_alamatmhs)

            startActivity(Intent(this@InputMhs,dashboard::class.java))
        }
    }
    fun postkeserver(data1:String,data2:String,data3:String){
        AndroidNetworking.post("http://192.168.100.26/androidterapan/mahasiswa/inputmhs.php")
            .addBodyParameter("nama_mahasiswa",data1)
            .addBodyParameter("nomer_mahasiswa",data2)
            .addBodyParameter("alamat_mahasiswa",data3)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }
            })
    }
}
