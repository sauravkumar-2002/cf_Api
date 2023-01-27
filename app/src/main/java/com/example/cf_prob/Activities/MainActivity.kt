package com.example.cf_prob.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cf_prob.*
import com.example.cf_prob.Adapters.Adapter
import com.example.cf_prob.databinding.ActivityMainBinding
import com.example.cf_prob.viewModels.Main_activity_view_model

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainActivityViewModel: Main_activity_view_model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainActivityViewModel = ViewModelProvider(this).get(Main_activity_view_model::class.java)


    }

    override fun onResume() {
        super.onResume()
        setProgressBar()
        loadProblems();

    }

    private fun loadProblems() {

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recView.layoutManager = layoutManager

        var adapter = Adapter()
        binding.recView.adapter = adapter
        mainActivityViewModel.prob_list.observe(this, {
            if (it != null) {
                binding.progressBar.visibility = View.GONE

            binding.progress.visibility = View.GONE
            Log.i("chec    recv", mainActivityViewModel.ct.toString())
            adapter.setProblems(it.result.problems)
        }
            else{
                Log.i("chec    recv", mainActivityViewModel.ct.toString())
            }
        })
        mainActivityViewModel.errorMessage.observe(this, {
            binding.progressBar.visibility = View.GONE
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        mainActivityViewModel.getAllProblems()
    }

    private fun setProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
        Log.i("chec    k", "uuu")
        val handler = Handler()
        var i = 0;
        i = binding.progressBar.progress
        Thread(Runnable {
            while (i < 100) {
                i += 1;
                handler.post(Runnable {
                    binding.progress.text = i.toString() + "/" + binding.progressBar.max
                })
                try {
                    Thread.sleep(20)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()

    }

}