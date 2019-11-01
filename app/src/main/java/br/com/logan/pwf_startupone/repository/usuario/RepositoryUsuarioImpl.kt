package br.com.logan.pwf_startupone.repository.usuario

import br.com.logan.pwf_startupone.api.usuario.UsuarioService
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

    override fun getUserByCpf(
        cpf: String,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        usuarioService
            .getUserByCpf(cpf)
            .enqueue(object : Callback<Usuario> {
                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }

    override fun getUserByNome(
        nome: String,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        usuarioService
            .getUserByNome(nome)
            .enqueue(object : Callback<Usuario> {
                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }

    override fun getAllUsers(onComplete: (List<Usuario>?) -> Unit, onError: (Throwable?) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createUser(
        usuario: Usuario,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        usuarioService
            .createUser(usuario)
            .enqueue(object : Callback<Usuario> {
                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }

    override fun updateUser(
        usuario: Usuario,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        usuarioService
            .createUser(usuario)
            .enqueue(object : Callback<Usuario> {
                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }

    override fun deleteUser(
        usuario: Usuario,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        usuarioService
            .createUser(usuario)
            .enqueue(object : Callback<Usuario> {
                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }
}