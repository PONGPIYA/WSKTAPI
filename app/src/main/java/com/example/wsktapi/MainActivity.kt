package com.example.wsktapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.recyclerview.widget.LinearLayoutManager

import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    final val TASK_NAME_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_list_posts.layoutManager = LinearLayoutManager(this)
        val retrofit = Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create(
            GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://dev.priorsolution.co.th/").build()


        val postsApi = retrofit.create(INetworkAPI::class.java)
        val response = postsApi.getAllPosts()
            response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler())
                .subscribe {
                    rv_list_posts.adapter = PostItemAdapter(it, this)
                }

        }
        fun newButtonClicked(view: View){
            val intent = Intent(this , MainActivity2::class.java)
            startActivityForResult(intent, TASK_NAME_REQUEST_CODE)
    }
}