package br.com.logan.pwf_startupone.usuario.api

import br.com.logan.pwf_startupone.utils.health.HealthResponse
import br.com.logan.pwf_startupone.usuario.model.Usuario
import br.com.logan.pwf_startupone.usuario.model.UsuarioResponse
import retrofit2.Call
import retrofit2.http.*

interface UsuarioService {

    @GET("/health")
    fun checkHealth(): Call<HealthResponse>

    @GET("/cliente/cpf/{cpf}")
    fun getUserByCpf(
        @Path("cpf") cpf: String
    ): Call<Usuario>

    @GET("/cliente/cpf/{nome}")
    fun getUserByNome(
        @Path("nome") nome: String
    ): Call<Usuario>

    @GET("/cliente/all")
    fun getAllUsers(): Call<UsuarioResponse>

    @POST("/cliente/add")
    fun createUser(
        @Body user: Usuario
    ): Call<Usuario>

    @PATCH("/cliente/update/{cpf}")
    fun updateUser(
        @Path("cpf") cpf: String,
        @Body usuario: Usuario
    ): Call<Usuario>

    @DELETE("/cliente/delete/{cpf}")
    fun deleteUser(
        @Path("cpf") cpf: String
    ): Call<Usuario>

}