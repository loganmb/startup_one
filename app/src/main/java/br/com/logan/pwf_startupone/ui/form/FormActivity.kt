package br.com.logan.pwf_startupone.ui.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.logan.pwf_startupone.R
import br.com.logan.pwf_startupone.model.user.Usuario
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuarioImpl
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        btCadastrar.setOnClickListener {

            val user = Usuario(
                txtName.text.toString(),
                txtEmail.text.toString(),
                "", "", "", "", "", "", "", ""
            )

            val cadastro = RepositoryUsuarioImpl()
            cadastro.save(user)
        }

        btCancelar.setOnClickListener {

        }
    }

}

