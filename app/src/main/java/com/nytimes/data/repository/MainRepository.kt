package com.nytimes.data.repository

import com.nytimes.data.api.ApiHelper
import javax.inject.Inject

/**
 * Created by sameer.khader on 21/01/2021.
 */
class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getMostPopular(page: Int) = apiHelper.mostPopular(page)

    suspend fun getNewsByType(type: String) = apiHelper.newsByType(type)

}