package br.iesb.mobile.ibeauty.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.ibeauty.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_recupera_senha1.*

class RecuperaSenha1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recupera_senha1)

        //BT Recuperação de Senha
        btRecuperaSenha.setOnClickListener {
            val email = tvEmailRecuperacao.text.toString()
            val auth = FirebaseAuth.getInstance()

            Toast.makeText(this, "AGUARDE, você receberá um e-mail para troca de senha", Toast.LENGTH_LONG).show()
            auth.sendPasswordResetEmail(email)
            finish()
        }
    }
}
