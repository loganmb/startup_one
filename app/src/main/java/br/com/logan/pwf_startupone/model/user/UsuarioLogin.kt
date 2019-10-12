package br.com.logan.pwf_startupone.model.user

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsuarioLogin(
    val emailLogin: String,
    val passwordLogin: String,
    val cpfLogin: String
) : Parcelable