package com.hamzaerdas.observerpatternexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel: ViewModel(){
    var date = MutableLiveData<String>()

    fun getTime(): MutableLiveData<String>{
        if(date.value == null){
            date = loadTime()
        }
        return date
    }

    private fun loadTime(): MutableLiveData<String> {
        val liveTime = MutableLiveData<String>()
        liveTime.value = Date().toString()
        return liveTime
    }
}