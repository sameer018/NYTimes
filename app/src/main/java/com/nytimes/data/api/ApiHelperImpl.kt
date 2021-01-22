package com.nytimes.data.api

import com.nytimes.BuildConfig
import com.nytimes.data.model.FeedWrapper
import com.nytimes.data.model.NewFeed
import javax.inject.Inject

/**
 * Created by sameer.khader on 21/01/2021.
 */
class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun mostPopular(page: Int): ArrayList<NewFeed> {
        var newFeeds: ArrayList<NewFeed> = arrayListOf()
        val feedWrapper = apiService.mostPopular(page, BuildConfig.API_KEY)
        if (feedWrapper.isSuccessful) {
            val feedWrapperData = feedWrapper.body() as FeedWrapper
            if (!feedWrapperData.newFeeds.isNullOrEmpty())
                newFeeds = feedWrapperData.newFeeds!!
        }
        return newFeeds
    }

    override suspend fun newsByType(type: String): ArrayList<NewFeed> {
        var newFeeds: ArrayList<NewFeed> = arrayListOf()
        val feedWrapper = apiService.newsByType(type, BuildConfig.API_KEY)
        if (feedWrapper.isSuccessful) {
            val feedWrapperData = feedWrapper.body() as FeedWrapper
            if (!feedWrapperData.newFeeds.isNullOrEmpty())
                newFeeds = feedWrapperData.newFeeds!!
        }
        return newFeeds
    }

}