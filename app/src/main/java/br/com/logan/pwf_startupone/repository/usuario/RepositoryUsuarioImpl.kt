package br.com.logan.pwf_startupone.repository.usuario

import br.com.logan.pwf_startupone.api.UsuarioService
import br.com.logan.pwf_startupone.model.HealthResponse
import br.com.logan.pwf_startupone.model.user.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryUsuarioImpl(val usuarioService: UsuarioService) : RepositoryUsuario {

    override fun checkHealth(onComplete: () -> Unit, onError: (Throwable?) -> Unit) {
        usuarioService.checkHealth()
            .enqueue(object : Callback<HealthResponse> {
                override fun onFailure(call: Call<HealthResponse>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(
                    call: Call<HealthResponse>, response:
                    Response<HealthResponse>
                ) {
                    onComplete()
                }
            })
    }

    override fun getUsuarios(
        size: Int,
        sort: String,
        onComplete: (List<Usuario>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun postUsuario() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}