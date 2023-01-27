package com.example.cf_prob.viewModels

import android.content.Context

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class First_screen_view_model(context: Context) : ViewModel() {
    var cf = "Code_Forces"
    var factLiveData = MutableLiveData<String>("first_screen");
    fun problemSet() {
        factLiveData.value = "go_to_problem_set"
    }
}