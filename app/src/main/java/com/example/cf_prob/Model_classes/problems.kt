package com.example.cf_prob.Model_classes

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "contact")
data class problems(
    @PrimaryKey(autoGenerate = true)
    var id:Long=0,
    var contestId:Int=0,
    var index:String?=null,
    var name:String?=null,
    var type:String?=null,
    var points:Float?=null,
    var rating:Int?=null,

   // var tags:List<String>?=null
)