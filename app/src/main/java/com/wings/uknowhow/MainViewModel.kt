package com.wings.uknowhow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val saveStateHandle: SavedStateHandle
) : ViewModel() {
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    private val _error = MutableLiveData(false)
    val error: LiveData<Boolean> = _error

    private val _sampleData = MutableLiveData<SampleData>()
    val sampleData: LiveData<SampleData> = _sampleData


    fun getSampleData() {
        _sampleData.value = SampleData(
            arrayListOf<Message>(
                Message("Hyeok", "Hello guys"),
                Message("Hye", "Hello guys"),
                Message(
                    "ok",
                    "this is my first compose project.\nthis is my first compose project.\nthis is my first compose project." +
                            "\n" +
                            "this is my first compose project.\n" +
                            "this is my first compose project." +
                            "\n" +
                            "this is my first compose project.\n" +
                            "this is my first compose project." +
                            "\n" +
                            "this is my first compose project.\n" +
                            "this is my first compose project."
                ),
                Message("eok", "guys"),
                Message("ffffk", "test"),
                Message("powerovjer", "hi")
            )
        )
    }


    fun onNameChange(newName: String) {
        _name.value = newName
        _error.value = newName == "error"   // boolean
    }
}