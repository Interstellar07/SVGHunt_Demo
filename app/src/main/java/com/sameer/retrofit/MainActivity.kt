package com.sameer.retrofit

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Adapter
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    lateinit var checkBox1: CheckBox
    lateinit var checkBox2: CheckBox
    lateinit var checkBox3: CheckBox
    lateinit var checkBox4: CheckBox
    lateinit var rcv : RecyclerView
    val list = ArrayList<MyDataItem>();
    ;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE)

        setContentView(R.layout.activity_main)
        println("here toh")

        val retrofitbuilder = Retrofit.Builder()
            .baseUrl("https://quizapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIinterface::class.java)


        val retrofitdata = retrofitbuilder.getproductData()
        retrofitdata.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responsebody = response.body()!!

                println("List size is "+ list.size)
                for(mydata in responsebody)
                {
                    list.add(mydata)


                }
                println("List size is "+ list.size)
                rcv = findViewById(R.id.rcv)
                rcv.layoutManager = LinearLayoutManager(this@MainActivity)
                rcv.adapter = Adapter(list,this@MainActivity);


            }


            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_LONG).show()
            }
        })


        //Ending of calling API and putting it into array
        println("Called acv")


        println("Called rcv")
    }





    //this function is to check if user presses home or leaves app for cheating
    override fun onUserLeaveHint() {
        // When user presses home page
        Toast.makeText(this,"Test Ended Bruh",Toast.LENGTH_LONG).show()
        println("You switched home page")
        super.onUserLeaveHint()
    }
}