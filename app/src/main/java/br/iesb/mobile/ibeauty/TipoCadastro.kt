package br.iesb.mobile.ibeauty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tipo_cadastro.*

class TipoCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_cadastro)

        ivVoltarTela.setOnClickListener {
            val intencaoDeChamada = Intent(this, MainActivity::class.java)
            startActivity(intencaoDeChamada)
        }

        btTipoCliente.setOnClickListener {
            val intencaoDeChamada = Intent(this, CadastroCliente1::class.java)
            startActivity((intencaoDeChamada))
        }

        linkLogin.setOnClickListener {
            val intencaoDeChamada = Intent(this, Login::class.java)
            startActivity(intencaoDeChamada)
        }

    }
}