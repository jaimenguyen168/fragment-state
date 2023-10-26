package com.example.fragment_state

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randall_images = intArrayOf(
            R.drawable.aquaman,
            R.drawable.blockbuster,
            R.drawable.always_be_my_maybe,
            R.drawable.ant_man___the_wasp,
            R.drawable.fresh_off_the_boat,
            R.drawable.larry_crowne,
            R.drawable.long_shot,
            R.drawable.office_christmas_party,
            R.drawable.paw_patrol,
            R.drawable.shortcoming,
            R.drawable.snatched,
            R.drawable.the_hollars,
            R.drawable.the_five_year_engagement,
            R.drawable.trainwreck,
            R.drawable.the_office,
            R.drawable.true_story_with_ed___randall
        )

        val imageListFragment = ImageListFragment.newInstance(randall_images)
        val imageDisplayFragment = ImageDisplayFragment.newInstance(R.drawable.aquaman)

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.imageListFCV, imageListFragment)
                .add(R.id.imageDisplayFCV, imageDisplayFragment)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()
    }
}
