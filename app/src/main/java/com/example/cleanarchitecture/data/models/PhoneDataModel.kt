package com.example.cleanarchitecture.data.models

import java.util.Date

data class Phones(val phones:List<PhoneDataModel>)
data class PhoneDataModel (
    val brandName:String?,
    val name:String?,
    val code:Int?,
    val date: Date?

)