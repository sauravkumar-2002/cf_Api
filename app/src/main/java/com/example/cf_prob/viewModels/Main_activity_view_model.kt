package com.example.cf_prob.viewModels

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cf_prob.Model_classes.ret_obj
import com.example.cf_prob.repositories.Main_aactivity_repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main_activity_view_model : ViewModel() {
    var prob_list = MutableLiveData<ret_obj>()
    val errorMessage = MutableLiveData<String>()
    var mainAactivityRepo = Main_aactivity_repo()
    var ct=0;
    fun getAllProblems() {

        val reqcall = mainAactivityRepo.getAllproblems()
        reqcall.enqueue(object : Callback<ret_obj> {
            override fun onResponse(call: Call<ret_obj>, response: Response<ret_obj>) {
                    ct++;
                    prob_list.postValue(response.body())
                    Log.i("check viewmodel", "uuu")

            }

            override fun onFailure(call: Call<ret_obj>, t: Throwable) {
                  //Toast.makeText(this@MainActivity, "failed", Toast.LENGTH_SHORT).show()
                errorMessage.value=t.message
            }

        })
    }
}