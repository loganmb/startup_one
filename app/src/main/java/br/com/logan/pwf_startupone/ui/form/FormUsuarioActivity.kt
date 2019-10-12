package br.com.logan.pwf_startupone.ui.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserManager
import androidx.lifecycle.MutableLiveData
import br.com.logan.pwf_startupone.R
import br.com.logan.pwf_startupone.model.user.EnderecoUsuario
import br.com.logan.pwf_startupone.model.user.Usuario
import br.com.logan.pwf_startupone.repository.usuario.RepositoryUsuarioImpl
import kotlinx.android.synthetic.main.activity_form.*
import org.koin.android.viewmodel.ext.android.viewModel

class FormUsuarioActivity : AppCompatActivity() {

    val formUsuarioViewModel: FormUsuarioViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        btCadastrar.setOnClickListener {

            val user = Usuario(
                txtName.text.toString(),
                txtEmail.text.toString(),
                "", "","", EnderecoUsuario("", "", "", "", "", "","")
            )

            formUsuarioViewModel.createUser(user)

        }

        btCancelar.setOnClickListener {

        }
    }

}

