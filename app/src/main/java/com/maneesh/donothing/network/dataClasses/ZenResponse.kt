package com.maneesh.donothing.network.dataClasses


import com.google.gson.annotations.SerializedName


data class ZenResponse (

    @SerializedName("q" ) var q : String? = null,
    @SerializedName("a" ) var a : String? = null,
    @SerializedName("h" ) var h : String? = null

)