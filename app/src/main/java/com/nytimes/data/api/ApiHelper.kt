package com.nytimes.data.api

import com.nytimes.data.model.NewFeed

interface ApiHelper {
    suspend fun mostPopular(page: Int): ArrayList<NewFeed>
}