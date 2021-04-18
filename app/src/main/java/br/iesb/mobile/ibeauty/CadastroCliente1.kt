package br.iesb.mobile.ibeauty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_cliente1.*
import kotlinx.android.synthetic.main.activity_cadastro_cliente1.ivVoltarTela
import kotlinx.android.synthetic.main.activity_tipo_cadastro.*

class CadastroCliente1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente1)

        btCadastroProx.setOnClickListener {
            val intencaoDeChamada = Intent(this, CadastroCliente2::class.java)
            startActivity(intencaoDeChamada)
        }

        ivVoltarTela.setOnClickListener {
            val intencaoDeChamada = Intent(this, TipoCadastro::class.java)
            startActivity(intencaoDeChamada)
        }
    }
}