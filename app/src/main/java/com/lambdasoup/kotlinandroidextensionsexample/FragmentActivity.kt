package com.lambdasoup.kotlinandroidextensionsexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        setSupportActionBar(toolbar)

        val fragment = when (intent.getIntExtra(KEY_EXTRA_WHICH_FRAGMENT, 0)) {
            EXTRA_BROKEN -> ViewPagerIndicatorFragmentBroken()
            EXTRA_WORKING -> ViewPagerIndicatorFragmentFixed()
            else -> ViewPagerIndicatorFragmentCached()
        }

        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit()
        }

    }

    companion object {
        private const val KEY_EXTRA_WHICH_FRAGMENT = "whichFragment"
        private const val EXTRA_BROKEN = 1
        private const val EXTRA_WORKING = 2

        fun getIntentBroken(context: Context): Intent = Intent(context, FragmentActivity::class.java)
                .putExtra(KEY_EXTRA_WHICH_FRAGMENT, EXTRA_BROKEN)

        fun getIntentWorking(context: Context): Intent = Intent(context, FragmentActivity::class.java)
                .putExtra(KEY_EXTRA_WHICH_FRAGMENT, EXTRA_WORKING)
    }
}
