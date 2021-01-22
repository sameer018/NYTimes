package com.nytimes.ui.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nytimes.R
import com.nytimes.data.model.NewFeed
import com.nytimes.data.network.Status
import com.nytimes.ui.main.viewmodel.PageViewModel


/**
 * A placeholder fragment containing a simple view.
 * Created by sameer.khader on 23/01/2021.
 */
class MainHolderFragment : Fragment() {
    private lateinit var pageViewModel: PageViewModel
    private lateinit var fContext: Context
    private lateinit var newFeedAdapter: NewFeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fContext = this.activity!!
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val recyclerView: RecyclerView = root.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(fContext)
        pageViewModel.newFeedList.observe(this, Observer {
            newFeedAdapter = NewFeedAdapter(fContext, it as ArrayList<NewFeed>)
            recyclerView.adapter = newFeedAdapter
        })
        pageViewModel.text.observe(this, Observer<String> {
            setupObserver()
        })

        return root
    }

    private fun setupObserver() {
        (fContext as MainActivity).mainViewModel.newFeedResource.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { newsFeeds -> renderList(newsFeeds as ArrayList<NewFeed>) }

                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                    Toast.makeText(fContext, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(newsFeeds: ArrayList<NewFeed>) {
        if (!newsFeeds.isNullOrEmpty()) {
            pageViewModel.setNewsFeed(newsFeeds)
            newFeedAdapter.notifyDataSetChanged()
        }
    }


    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): MainHolderFragment {
            return MainHolderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}