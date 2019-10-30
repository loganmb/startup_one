package br.com.logan.pwf_startupone.ui.singup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.logan.pwf_startupone.model.user.Usuario
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuario

class SingUpViewModel
    (val repositoryUsuario: RepositoryUsuario) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val messageResponse = MutableLiveData<String>()


    fun createUser(usuario: Usuario) {
        isLoading.value = true
        repositoryUsuario.createUser(usuario, {
            isLoading.value = false
            messageResponse.value = "Dados gravados com sucesso!"
        }, {
            isLoading.value = false
            messageResponse.value = it?.message
        })
    }
}
