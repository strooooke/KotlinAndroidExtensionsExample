package com.lambdasoup.kotlinandroidextensionsexample

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CountingAdapter(private val inflater: LayoutInflater): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val page = (inflater.inflate(R.layout.view_page, container, false) as TextView).apply {
            text = (position + 1).toString()
        }

        container.addView(page)

        return page
    }

    override fun destroyItem(container: ViewGroup, position: Int, key: Any) {
        container.removeView(key as View)
    }

    override fun isViewFromObject(view: View, key: Any): Boolean = view == key

    override fun getCount(): Int = 3

    val lastPosition = count - 1
}