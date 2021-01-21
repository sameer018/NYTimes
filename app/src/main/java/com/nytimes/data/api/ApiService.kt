package com.nytimes.data.api

import com.nytimes.data.model.FeedWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("svc/mostpopular/v2/viewed/{pageNo}.json")
    suspend fun mostPopular(
        @Path("pageNo") pageNo: Int,
        @Query("api-key") apiKey: String
    ): Response<FeedWrapper>
}