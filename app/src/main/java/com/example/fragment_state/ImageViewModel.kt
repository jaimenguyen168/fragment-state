package com.example.fragment_state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel : ViewModel() {
    private val selectedImage = MutableLiveData<Int>()

    fun setSelectedImage(imageId: Int) {
        selectedImage.value = imageId
    }

    fun getSelectedImage() : LiveData<Int> = selectedImage
}