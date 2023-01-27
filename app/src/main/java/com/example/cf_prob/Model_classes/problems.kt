package com.example.cf_prob.Model_classes

data class problems(
    var contestId:Int=0,
    var index:String?=null,
    var name:String?=null,
    var type:String?=null,
    var points:Float?=null,
    var rating:Int?=null,

    var tags:List<String>?=null
)