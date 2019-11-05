package br.com.logan.pwf_startupone.usuario.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Usuario (
    val cpf : String,
    val uuid: String,
    val nome : String,
    val email : String,
    val data_nascimento : String,
    val endereco: UsuarioEndereco

) : Parcelable