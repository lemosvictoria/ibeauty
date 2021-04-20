package br.iesb.mobile.ibeauty.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.ibeauty.R
import kotlinx.android.synthetic.main.activity_tipo_cadastro.*

class TipoCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_cadastro)

        btVoltarTela.setOnClickListener {
            finish()
        }

        btTipoCliente.setOnClickListener {
            val intencaoDeChamada = Intent(this, CadastroCliente1::class.java)
            startActivity((intencaoDeChamada))
        }

        btTipoProfissional.setOnClickListener {
            val intencaoDeChamada = Intent(this, CadastroProfissional1::class.java)
            startActivity((intencaoDeChamada))
        }

        linkLogin.setOnClickListener {
            val intencaoDeChamada = Intent(this, LoginActivity::class.java)
            startActivity(intencaoDeChamada)
        }

    }
}