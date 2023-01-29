package com.example.cf_prob.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cf_prob.Model_classes.problems

@Database(entities = [problems::class], version = 1)
abstract  class ProblemsDatabase : RoomDatabase(){

    abstract fun comntactDao():ContactDAO

    companion object{
        @Volatile
        private  var inst:ProblemsDatabase?=null
        fun getDatabase(context:Context):ProblemsDatabase{
          if(inst==null){
            synchronized(this){
                inst=Room.databaseBuilder(context.applicationContext,
                ProblemsDatabase::class.java,"contactDb").build()
            }
          }
            return inst!!
        }
    }

}