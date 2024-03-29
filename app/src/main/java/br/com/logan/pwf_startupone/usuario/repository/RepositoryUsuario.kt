package br.com.logan.pwf_startupone.usuario.repository

import br.com.logan.pwf_startupone.usuario.model.Usuario

interface RepositoryUsuario {

    fun checkHealth(
        onComplete: () -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun getUserByCpf(
        cpf: String,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun getUserByNome(
        nome: String,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun getAllUsers(
        onComplete: (List<Usuario>?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun createUser(
        usuario: Usuario,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun updateUser(
        usuario: Usuario,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun deleteUser(
        usuario: Usuario,
        onComplete: (Usuario?) -> Unit,
        onError: (Throwable?) -> Unit
    )

}