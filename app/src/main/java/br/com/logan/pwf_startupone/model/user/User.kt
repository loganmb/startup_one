package br.com.logan.pwf_startupone.model.user

import java.util.*

data class User(
    val name : String,
    val email : String,
    val address : UserAddress,
    val birth_date : Date
)