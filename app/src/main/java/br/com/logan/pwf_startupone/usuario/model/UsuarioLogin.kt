package br.com.logan.pwf_startupone.usuario.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsuarioLogin(
    val nome: String,
    val email: String
) : Parcelable