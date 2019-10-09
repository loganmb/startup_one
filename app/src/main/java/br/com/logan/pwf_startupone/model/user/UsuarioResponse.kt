package br.com.logan.pwf_startupone.model.user

import com.google.gson.annotations.SerializedName

data class UsuarioResponse (
    @SerializedName("content") val usuarios : List<Usuario>
)