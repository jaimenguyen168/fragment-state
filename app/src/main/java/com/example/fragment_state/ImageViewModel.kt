package com.example.fragment_state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel() {
    private val selectedImage = MutableLiveData<Int>()
    private val images = MutableLiveData<IntArray>()

    var hasSeenSelection = true

    fun setSelectedImage(imageId: Int) {
        hasSeenSelection = false
        selectedImage.value = imageId
    }

    fun getSelectedImage() : LiveData<Int> = selectedImage

    fun setImages(newImages: IntArray) {
        images.value = newImages
    }

    fun getImages() : LiveData<IntArray> = images
}