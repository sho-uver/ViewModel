package com.example.mvvmexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodel.utils.Event
import com.example.viewmodel.utils.EventObserver

class MainViewModel : ViewModel() {

    // LiveDataでデータを保持
    private val _text = MutableLiveData<String>("Hello from ViewModel")
    val onTransit = MutableLiveData<Event<String>>(Event("born"))
    val text: LiveData<String> get() = _text

    // データを更新する関数
    fun updateText(newText: String) {
        _text.value = newText
    }

    fun onClickButton1() {
        onTransit.value = Event("onTransit1")
    }
    fun onClickButton2() {
        onTransit.value = Event("onTransit2")
    }

}
