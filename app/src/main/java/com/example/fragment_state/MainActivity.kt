package com.example.fragment_state

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private var isTwoContainers = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isTwoContainers = findViewById<View>(R.id.landImageDisplayFCV) != null

        val imageViewModel = ViewModelProvider(this)[ImageViewModel::class.java]

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

        val fragment = ImageListFragment()

        if (savedInstanceState == null)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.imageListFCV, fragment)
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .commit()

        if (isTwoContainers)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.landImageDisplayFCV, ImageDisplayFragment())
                .commit()

        imageViewModel.setImages(randall_images)

        imageViewModel.getSelectedImage().observe(this){
            if (!imageViewModel.hasSeenSelection and !isTwoContainers) {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.imageListFCV, ImageDisplayFragment())
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit()
                imageViewModel.hasSeenSelection = true
            }
        }
    }
}
