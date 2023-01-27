package com.example.cf_prob.viewModels.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cf_prob.viewModels.First_screen_view_model

class first_screen_factory(var context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  First_screen_view_model(context) as T
    }
}