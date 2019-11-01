package br.com.logan.pwf_startupone.api.startup.startup_tools

import br.com.logan.pwf_startupone.model.HealthResponse
import br.com.logan.pwf_startupone.model.startup.Startup
import br.com.logan.pwf_startupone.model.user.UsuarioResponse
import retrofit2.Call
import retrofit2.http.*

interface StartupService {

    @GET("/health")
    fun checkHealth(): Call<HealthResponse>

    @GET("/startup/busca/nome/{nome}")
    fun getUserByNome(
        @Path("nome") nome: String
    ): Call<Startup>

    @GET("/startup/all")
    fun getAllUsers(): Call<UsuarioResponse>

    @POST("/startup/add")
    fun createUser(
        @Body user: Startup
    ): Call<Startup>

    @PATCH("/startup/update")
    fun updateUser(
        @Path("cpf") cpf: String,
        @Body startup: Startup
    ): Call<Startup>

    @DELETE("/startup/delete/")
    fun deleteUser(
        @Path("cpf") cpf: String
    ): Call<Startup>

}