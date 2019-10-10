package br.com.logan.pwf_startupone.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuario

class SplashViewModel(val repositoryUsuario: RepositoryUsuario) : ViewModel() {
    val messageError: MutableLiveData<String> = MutableLiveData()
    fun checkHealth() {
        repositoryUsuario.checkHealth(
            onComplete = {
                messageError.value = ""
            },
            onError = {
                messageError.value = it?.message
            }
        )
    }
}