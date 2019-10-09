package br.com.logan.pwf_startupone.repository.usuario

import br.com.logan.pwf_startupone.api.UsuarioService
import br.com.logan.pwf_startupone.model.user.Usuario

class RepositoryUsuarioImpl(val usuarioService: UsuarioService) : RepositoryUsuario{


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