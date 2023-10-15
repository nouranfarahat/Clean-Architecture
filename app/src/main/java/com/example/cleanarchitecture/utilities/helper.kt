package com.example.cleanarchitecture.utilities

import android.content.Context
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.data.models.PhoneBrandEnum

fun getBrandName(context: Context,phoneTypeName: String):String
{
    var phoneBrand:String
    when(phoneTypeName)
    {
        PhoneBrandEnum.SAMSUNG.name -> phoneBrand=context.getString(R.string.samsung)
        PhoneBrandEnum.IPHONE.name -> phoneBrand=context.getString(R.string.iphone)
        else -> phoneBrand=context.getString(R.string.unknown)
    }
    return phoneBrand
}