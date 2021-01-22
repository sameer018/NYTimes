package com.nytimes.data.api

import com.nytimes.data.model.NewFeed

/**
 * Created by sameer.khader on 21/01/2021.
 */
interface ApiHelper {
    suspend fun mostPopular(page: Int): ArrayList<NewFeed>
    suspend fun newsByType(type: String): ArrayList<NewFeed>

}