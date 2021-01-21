package com.nytimes.data.api

import com.nytimes.BuildConfig
import com.nytimes.data.model.FeedWrapper
import com.nytimes.data.model.NewFeed
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun mostPopular(page: Int): ArrayList<NewFeed> {
        var newFeeds: ArrayList<NewFeed> = arrayListOf()
        val feedWrapper = apiService.mostPopular(page, BuildConfig.API_KEY)
        if (feedWrapper.isSuccessful) {
            val feedWrapperData = feedWrapper.body() as FeedWrapper
            if (feedWrapperData.newFeeds.isNullOrEmpty())
                newFeeds = feedWrapperData.newFeeds!!
        }
        return newFeeds
    }

}