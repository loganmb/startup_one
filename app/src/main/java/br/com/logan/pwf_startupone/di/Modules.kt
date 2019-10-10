package br.com.logan.pwf_startupone.di

import br.com.logan.pwf_startupone.api.UsuarioService
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuario
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuarioImpl
import br.com.logan.pwf_startupone.ui.splash.SplashViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://crud-mysql-heroku-cliente.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
}
val repositoryModule = module {
    single<RepositoryUsuario> { RepositoryUsuarioImpl(get()) }
}
val networkModule = module {
    single { createNetworkClient(get()).create(UsuarioService::class.java) }
}