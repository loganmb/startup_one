package br.com.logan.pwf_startupone.ui.singup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.logan.pwf_startupone.model.user.Usuario
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuario

class SingUpViewModel(
private val repositoryUsuario: RepositoryUsuario
) : ViewModel() {

    private val isLoading = MutableLiveData<Boolean>()
    private val messageResponse = MutableLiveData<String>()

    fun createUser(user: Usuario) {
        isLoading.value = true
        repositoryUsuario.createUser(user, {
            isLoading.value = false
            messageResponse.value = "Dados gravados com sucesso!"
        }, {
            isLoading.value = false
            messageResponse.value = it?.message
        })
    }

}