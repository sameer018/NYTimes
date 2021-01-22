package com.nytimes.data.api

import com.nytimes.data.model.FeedWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by sameer.khader on 21/01/2021.
 */
interface ApiService {
    @GET("mostpopular/v2/viewed/{pageNo}.json")
    suspend fun mostPopular(
        @Path("pageNo") pageNo: Int,
        @Query("api-key") apiKey: String
    ): Response<FeedWrapper>

    @GET("topstories/v2/{type}.json")
    suspend fun newsByType(
        @Path("type") type: String,
        @Query("api-key") apiKey: String
    ): Response<FeedWrapper>
}