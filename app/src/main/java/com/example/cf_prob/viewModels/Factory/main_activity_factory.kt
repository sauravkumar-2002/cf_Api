package com.example.cf_prob.viewModels.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cf_prob.viewModels.First_screen_view_model
import com.example.cf_prob.viewModels.Main_activity_view_model

class main_activity_factory(var context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  Main_activity_view_model(context) as T
    }
}