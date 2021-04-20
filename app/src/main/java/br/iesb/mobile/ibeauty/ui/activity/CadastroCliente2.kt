package br.iesb.mobile.ibeauty.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.ibeauty.R
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_cadastro_cliente2.*

class CadastroCliente2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente2)

        btVoltarTela.setOnClickListener {
            finish()
        }

        //BT Cadastrar
        btCadastrar.setOnClickListener {
            cadastrar()
        }
    }

    //Funcao Valida Cadastro Cliente
    private fun cadastrar(){
        val email = tvEmailCadastro.text.toString()
        val password = tvSenhaCadastro.text.toString()
        val confirmaPass = tvConfirmarSenha.text.toString()

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