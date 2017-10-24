package com.lambdasoup.kotlinandroidextensionsexample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_viewpagerindicator.view.*

class ViewPagerIndicatorFragmentBroken: Fragment() {

    private lateinit var pagerAdapter: CountingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_viewpagerindicator, container, false).apply {
                pagerAdapter = CountingAdapter(inflater)

                viewpager.adapter = pagerAdapter

                with(page_indicator) {
                    setViewPager(viewpager)
                    setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
                        override fun onPageSelected(position: Int) {
                            button_forward.setText(
                                    if (position == pagerAdapter.lastPosition) {
                                        R.string.button_done
                                    } else {
                                        R.string.button_skip
                                    }
                            )

                        }
                    })
                }

                with(button_forward){
                    setOnClickListener { _ -> activity.finish()}
                    setBackgroundColor(ResourcesCompat.getColor(resources, android.R.color.holo_blue_light, null))
                }
            }
}
