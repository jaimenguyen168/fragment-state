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



        val imageViewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        isTwoContainers = findViewById<View>(R.id.landImageDisplayFCV) != null

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

        imageViewModel.setImages(randall_images)

//        if (savedInstanceState == null)
//            imageViewModel.setImages()
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.imageListFCV, fragment)
//                .addToBackStack(null)
//                .setReorderingAllowed(true)
//                .commit()

        imageViewModel.getSelectedImage().observe(this) {
            if (findViewById<View>(R.id.landImageDisplayFCV) != null) {
                supportFragmentManager
                    .beginTransaction()
                    .add(R.id.landImageDisplayFCV, ImageDisplayFragment())
                    .addToBackStack(null)
                    .setReorderingAllowed(true)
                    .commit()

            } else {
                if (!imageViewModel.hasSeenSelection) {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.imageListFCV, ImageDisplayFragment())
                        .addToBackStack(null)
                        .setReorderingAllowed(true)
                        .commit()
                    imageViewModel.hasSeenSelection = false
                }
            }
        }

//        if (isTwoContainers)
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.landImageDisplayFCV, ImageDisplayFragment())
//                .addToBackStack(null)
//                .setReorderingAllowed(true)
//                .commit()
//

//
//        imageViewModel.getSelectedImage().observe(this){
//            if (findViewById<View>(R.id.landImageDisplayFCV) == null) {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.imageListFCV, ImageDisplayFragment())
//                    .addToBackStack(null)
//                    .setReorderingAllowed(true)
//                    .commit()
//                imageViewModel.hasSeenSelection = true
//            } else {
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.imageListFCV, ImageListFragment())
//                    .commit()
//            }
//        }
    }
}
