package br.com.logan.pwf_startupone.usuario.model

import com.google.gson.annotations.SerializedName

data class UsuarioResponse (
    @SerializedName("content") val usuarios : List<Usuario>
)