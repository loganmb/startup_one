package br.com.logan.pwf_startupone.ui.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import br.com.logan.pwf_startupone.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.lifecycle.Observer
import br.com.logan.pwf_startupone.ui.login.LoginActivity
import br.com.logan.pwf_startupone.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val TEMPO_AGUARDO_SPLASHSCREEN = 3500L

    val splashViewModel: SplashViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val preferences = getSharedPreferences("", Context.MODE_PRIVATE)

        val isFirstOpen = preferences.getBoolean("open_first", true)

        if(isFirstOpen) {
            markAppAlreadyOpen(preferences)
            carregar()
        }else{
            showLogin()
        }

    //    splashViewModel.checkHealth()
    //    splashViewModel.messageError.observe(this, Observer {
    //        if (it == "") {
    //            startActivity(Intent(this, MainActivity::class.java))
    //            finish()
    //        } else {
    //            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
    //        }
    //    })
    }

    private fun markAppAlreadyOpen(preferences: SharedPreferences) {
        val editor = preferences.edit()
        editor.putBoolean("open_first", false)
        editor.apply()
    }

    private fun showLogin() {
        val nextScreen = Intent(this@SplashActivity, LoginActivity::class.java)
        startActivity(nextScreen)
        finish()
    }

    private fun carregar() {
        //carrega a animação
        val anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        anim.reset()
        ivLogo.clearAnimation()
        //Roda a animação
        ivLogo.startAnimation(anim)
        //Chama a proxoma tela após 3.5 segundos definido na SPLASH_DISPLAY_LENGTH
        Handler().postDelayed({
            val proximaTela = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(proximaTela)
            finish()
        }, TEMPO_AGUARDO_SPLASHSCREEN
        )
    }

}
