package br.iesb.mobile.ibeauty.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.ibeauty.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_tipo_cadastro.btVoltarTela

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Bt Voltar
        btVoltarTela.setOnClickListener {
            finish()
        }

        //Autentica Firebase
        btLogin.setOnClickListener {
            val email = emailLogin.text.toString()
            val password = senhaLogin.text.toString()
            val auth = FirebaseAuth.getInstance()

            val taskDeLogin = auth.signInWithEmailAndPassword(email, password)
            taskDeLogin.addOnCompleteListener { resultado ->
                if (resultado.isSuccessful){
                    val irPraHome = Intent(this, HomeActivity::class.java)
                    startActivity(irPraHome)
                }else{
                    Toast.makeText(this,"E-mail e/ou Senha Incorretos!",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}