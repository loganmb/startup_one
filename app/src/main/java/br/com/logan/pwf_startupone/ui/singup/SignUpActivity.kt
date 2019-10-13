package br.com.logan.pwf_startupone.ui.singup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.logan.pwf_startupone.R
import br.com.logan.pwf_startupone.model.user.EnderecoUsuario
import br.com.logan.pwf_startupone.model.user.Usuario
import br.com.logan.pwf_startupone.model.user.UsuarioLogin
import br.com.logan.pwf_startupone.utils.md5
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_form.btCadastrar
import kotlinx.android.synthetic.main.activity_form.btCancelar
import kotlinx.android.synthetic.main.activity_form.txtEmail
import kotlinx.android.synthetic.main.activity_form.txtName
import kotlinx.android.synthetic.main.activity_form.txtPassword
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sing_up.*
import org.koin.android.viewmodel.ext.android.viewModel

class SignUpActivity : AppCompatActivity() {

    private val singUpViewModel: SingUpViewModel by viewModel()

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)


        btCadastrar.setOnClickListener {



            //    singUpViewModel.createUser(user)

            mAuth = FirebaseAuth.getInstance()

            mAuth.createUserWithEmailAndPassword(
                txtEmail.text.toString(),
                txtPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    saveInRealTimeDatabase()
                    val userAPI = Usuario(
                        txtCpf.text.toString(),
                        txtName.text.toString(),
                        (FirebaseAuth.getInstance().currentUser!!.uid),
                        txtEmail.text.toString(), "",
                        EnderecoUsuario ("", "", "", "", "", "", "")
                    )
                    singUpViewModel.createUser(userAPI)
                } else {
                    Toast.makeText(this@SignUpActivity, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }

        }

        btCancelar.setOnClickListener {

            val returnIntent = Intent()
            setResult(RESULT_OK, returnIntent)
            finish()

        }
    }


    private fun saveInRealTimeDatabase() {
        val user = UsuarioLogin(
            txtEmail.text.toString(),
            (txtPassword.text.toString()).md5(),
            txtCpf.text.toString()
        )

        FirebaseDatabase.getInstance().getReference("Users")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(user)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Usuario criado com sucesso", Toast.LENGTH_SHORT)
                        .show()
                    val returnIntent = Intent()
                    returnIntent.putExtra("userLogin", user)
                    setResult(RESULT_OK, returnIntent)
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao criar usuario", Toast.LENGTH_SHORT).show()
                }
            }
    }

}
