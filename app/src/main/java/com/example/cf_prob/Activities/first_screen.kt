package com.example.cf_prob.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.cf_prob.Adapters.Adapter
import com.example.cf_prob.R
import com.example.cf_prob.databinding.ActivityFirstScreenBinding
import com.example.cf_prob.viewModels.Factory.first_screen_factory
import com.example.cf_prob.viewModels.First_screen_view_model
import com.example.cf_prob.viewModels.Main_activity_view_model

class first_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivityFirstScreenBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_first_screen)
        var first_screen_view_model: First_screen_view_model = ViewModelProvider(
            this,
            first_screen_factory(this)
        ).get(First_screen_view_model::class.java)
        var mainActivityViewModel: Main_activity_view_model = ViewModelProvider(
            this,).get(Main_activity_view_model::class.java)


        binding.firstScreenViewModel = first_screen_view_model
        binding.mainScreenViewModel=mainActivityViewModel



        first_screen_view_model.factLiveData.observe(this, {
            if (it == "go_to_problem_set") {
                var intent = Intent(this, MainActivity::class.java);
                startActivity(intent)
            }
        })
    }

}