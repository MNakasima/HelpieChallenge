package com.mnakasima.helpiechallenge.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val userId:String?,

    @SerializedName("name")
    val userName:String?,

    @SerializedName("email")
    val userEmail:String?,

    @SerializedName("company")
    val userCompany:Company?,

    @SerializedName("address")
    val userCity:Address?

)

data class Company(
    @SerializedName("name")
    val companyName: String?
)

data class Address(
    @SerializedName("city")
    val addressCity: String?
)
