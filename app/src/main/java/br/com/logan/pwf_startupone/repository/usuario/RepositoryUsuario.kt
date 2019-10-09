package br.com.logan.pwf_startupone.repository.usuario

import br.com.logan.pwf_startupone.model.user.Usuario

interface RepositoryUsuario {
    fun getUsuarios(
        size: Int,
        sort: String,
        onComplete: (List<Usuario>?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun postUsuario(
        usuario: Usuario,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    )
}