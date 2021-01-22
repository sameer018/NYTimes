package com.nytimes.ui.main.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.nytimes.R
import com.nytimes.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by sameer.khader on 21/01/2021.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    public val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val titles: Array<String> = resources.getStringArray(R.array.tab_content_title)
        val sectionsPagerAdapter = TabSectionPagerAdapter(titles, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        viewPager.offscreenPageLimit = 1
        viewPager.currentItem = 0
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                mainViewModel.fetchDataByType(if (position != 0) resources.getStringArray(R.array.tab_content_type)[position] else null)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }
}