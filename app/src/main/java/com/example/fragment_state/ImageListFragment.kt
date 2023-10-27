package com.example.fragment_state

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

const val IMAGE_ARRAY_KEY = "imageArrayKey"

class ImageListFragment : Fragment() {

    lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let { item ->
//            item.getIntArray(IMAGE_ARRAY_KEY)?.let {
//                images = it
//            }
//        }

        imageViewModel = ViewModelProvider(requireActivity())[ImageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with (view as RecyclerView) {
            layoutManager = GridLayoutManager(requireContext(), 2)
            imageViewModel.getImages().observe(requireActivity()) { it ->
                adapter = CustomAdapter(it) {
                    imageViewModel.setSelectedImage(it)
                }
            }

        }
    }

//    companion object {
//        fun newInstance(images: IntArray) =
//            ImageListFragment().apply {
//                arguments = Bundle().apply {
//                    putIntArray(IMAGE_ARRAY_KEY, images)
//                }
//            }
//    }
}

class CustomAdapter(private val images: IntArray, private val callback: (Int)->Unit) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    inner class MyViewHolder(val imageView: ImageView) : ViewHolder(imageView) {
        init {
            imageView.setOnClickListener{ callback(images[adapterPosition]) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ImageView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(450, 450)
            setPadding(20,0,20, 0)
        }
    )

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.setImageResource(images[position])
    }
}