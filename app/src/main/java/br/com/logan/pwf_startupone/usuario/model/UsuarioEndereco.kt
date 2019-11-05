package br.com.logan.pwf_startupone.usuario.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class UsuarioEndereco(
    val rua : String,
    val bairro : String,
    val numero : String,
    val cidade : String,
    val estado : String,
    val cep: String,
    val pais : String
) : Parcelable