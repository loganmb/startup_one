package br.com.logan.pwf_startupone.model.user

import java.util.*

data class Usuario(
    val name : String,
    val email : String,
    val birth_date : String,
    val street : String,
    val number : String,
    val complement : String,
    val district : String,
    val city : String,
    val state : String,
    val country : String
)