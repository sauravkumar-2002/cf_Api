package com.example.cf_prob.viewModels

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cf_prob.Model_classes.problems
import com.example.cf_prob.Model_classes.ret_obj
import com.example.cf_prob.database.ProblemsDatabase
import com.example.cf_prob.repositories.Main_aactivity_repo
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main_activity_view_model(context: Context) : ViewModel() {
    var cc=context
    var prob_list = MutableLiveData<List<problems>>()
    var database=ProblemsDatabase.getDatabase(cc)
    val errorMessage = MutableLiveData<String>()
    var mainAactivityRepo = Main_aactivity_repo()

    var ct=0;


    fun getAllProblems() {


    GlobalScope.launch(Dispatchers.IO){
        Log.i("check Thread", Thread.currentThread().name)
        val reqcall = mainAactivityRepo.getAllproblems()

        reqcall.enqueue(object : Callback<ret_obj> {
            override fun onResponse(call: Call<ret_obj>, response: Response<ret_obj>) {
                ct++;
                prob_list.postValue(response.body()?.result?.problems)
                Log.i("check viewmodel", "uuu")

            }

            override fun onFailure(call: Call<ret_obj>, t: Throwable) {
                //Toast.makeText(this@MainActivity, "failed", Toast.LENGTH_SHORT).show()

                errorMessage.value = t.message
            }

        })



}


    }
}