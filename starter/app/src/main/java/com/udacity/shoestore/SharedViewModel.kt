package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel: ViewModel() {

    var shoeList: MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf<Shoe>())

    fun addShoe(shoe:Shoe) {
        shoeList.value?.add(shoe)
    }


}