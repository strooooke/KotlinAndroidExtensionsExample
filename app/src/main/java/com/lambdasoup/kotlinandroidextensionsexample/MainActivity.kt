package com.lambdasoup.kotlinandroidextensionsexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val itemsAdapter = ItemsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        content_list.adapter = itemsAdapter

        fab.setOnClickListener { _ ->
            itemsAdapter.addItem()
        }
    }






    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_viewpager_fragment_broken -> startActivity(FragmentActivity.getIntentBroken(this))
            R.id.menu_viewpager_fragment_working -> startActivity(FragmentActivity.getIntentWorking(this))
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }
}
