package br.com.logan.pwf_startupone.di

import br.com.logan.pwf_startupone.api.AuthInterceptor
import br.com.logan.pwf_startupone.api.usuario.UsuarioService
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuario
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuarioImpl
import br.com.logan.pwf_startupone.ui.singup.SingUpViewModel
import br.com.logan.pwf_startupone.ui.splash.SplashViewModel
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { SingUpViewModel(get()) }
}
val repositoryModule = module {
    single<RepositoryUsuario> { RepositoryUsuarioImpl(get()) }
}
val networkModule = module {
    single<Interceptor> { AuthInterceptor() }
    single { createNetworkClient(get()).create(UsuarioService::class.java) }
    single { createOkhttpClientAuth(get()) }
}

private fun createOkhttpClientAuth(authInterceptor: Interceptor): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addNetworkInterceptor(StethoInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
    return builder.build()
}

private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://crud-mysql-heroku-cliente.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}