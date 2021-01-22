package com.nytimes.ui.main.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nytimes.data.model.NewFeed
import com.nytimes.data.network.NetworkHelper
import com.nytimes.data.network.Resource
import com.nytimes.data.repository.MainRepository
import kotlinx.coroutines.launch

/**
 * Created by sameer.khader on 23/01/2021.
 */
class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _newsFeeds = MutableLiveData<Resource<List<NewFeed>>>()
    val newFeedResource: LiveData<Resource<List<NewFeed>>>
        get() = _newsFeeds

    init {
        fetchDataByType(null)
    }

    fun fetchDataByType(type: String?) {
        if (type == null)
            fetchMostPopularFeeds()
        else
            fetchNewsFeedsByType(type)

    }

    private fun fetchMostPopularFeeds() {
        viewModelScope.launch {
            _newsFeeds.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getMostPopular(1).let {
                    _newsFeeds.postValue(Resource.success(it))
                }
            } else _newsFeeds.postValue(Resource.error("No internet connection", null))
        }
    }

    private fun fetchNewsFeedsByType(type: String) {
        viewModelScope.launch {
            _newsFeeds.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getNewsByType(type).let {
                    _newsFeeds.postValue(Resource.success(it))
                }
            } else _newsFeeds.postValue(Resource.error("No internet connection", null))
        }
    }

}