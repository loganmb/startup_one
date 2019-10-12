package br.com.logan.pwf_startupone.model.user

data class EnderecoUsuario(
    val street : String,
    val district : String,
    val number : String,
    val city : String,
    val state : String,
    val postalCode: String,
    val country : String
)