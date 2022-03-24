package com.system.demo_retrofit.entidades.entidades

import com.google.gson.annotations.SerializedName

data class Usuario(
    @SerializedName("userId") var userId:Int,
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("body")var body:String
) {

}