package com.nytimes.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nytimes.data.model.NewFeed

/**
 * Created by sameer.khader on 23/01/2021.
 */
class PageViewModel : ViewModel() {
    private val _index = MutableLiveData<Int>()
    private val _newsFeed = MutableLiveData<List<NewFeed>>()

    val text: LiveData<String> = Transformations.map(_index) {
        "$it"
    }

    val newFeedList: LiveData<List<NewFeed>> = Transformations.map(_newsFeed) {
        it
    }

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun setNewsFeed(newsFeed: List<NewFeed>) {
        _newsFeed.value = newsFeed
    }

}