package br.iesb.mobile.ibeauty.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.ibeauty.R
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_cadastro_profissional2.*

class CadastroProfissional2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_profissional2)

        //BT Voltar
        btVoltarProf2.setOnClickListener {
            finish()
        }

        //BT Cadastrar
        btCadastroProf2.setOnClickListener {
            cadastrar()
        }
    }

    //Funcao Valida Cadastro Profissional
    private fun cadastrar(){
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val confirmaPass = etPassword2.text.toString()

        if (password != confirmaPass){
            Toast.makeText(this, "Senhas não conferem!", Toast.LENGTH_LONG).show()
            return
        }

        val auth = FirebaseAuth.getInstance()
        val taskDeLogin = auth.createUserWithEmailAndPassword(email, password)

        taskDeLogin.addOnCompleteListener { resultado ->
            if (resultado.isSuccessful) {
                val intencaoDeChamada = Intent(this, LoginActivity::class.java)
                startActivity(intencaoDeChamada)
            } else {
                Toast.makeText(this, "Erro no Cadastro! Tente Novamente!", Toast.LENGTH_LONG).show()
            }
        }
    }

}