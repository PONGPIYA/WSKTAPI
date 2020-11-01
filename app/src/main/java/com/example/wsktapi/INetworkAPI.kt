package com.example.wsktapi

import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {

    @GET("test/job_list.json")
    fun getAllPosts(): Observable<List<Post>>
}