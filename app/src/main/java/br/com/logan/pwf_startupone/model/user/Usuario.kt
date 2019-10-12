package br.com.logan.pwf_startupone.model.user

data class Usuario (
    val cpf : String,
    val name : String,
    val uuid: String,
    val email : String,
    val birth_date : String,
    val enderecoUsuario: EnderecoUsuario

)