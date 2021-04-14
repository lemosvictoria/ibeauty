package br.iesb.mobile.ibeauty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tipo_cadastro.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ivVoltarTela.setOnClickListener {
            val intencaoDeChamada = Intent(this, TipoCadastro::class.java)
            startActivity(intencaoDeChamada)
        }
    }
}