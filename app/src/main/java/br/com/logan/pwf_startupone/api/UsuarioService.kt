package br.com.logan.pwf_startupone.api

import br.com.logan.pwf_startupone.model.user.Usuario
import br.com.logan.pwf_startupone.model.user.UsuarioResponse
import retrofit2.Call
import retrofit2.http.*

interface UsuarioService {

    @POST("")
    fun postUser(@Body user : Usuario)

    @GET("")
    fun getUser() : Call<UsuarioResponse>

    @PUT
    fun updateUser(@Body usuario : Usuario) : Call<Usuario>

}