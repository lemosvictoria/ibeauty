package br.iesb.mobile.ibeauty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_cliente2.*
import kotlinx.android.synthetic.main.activity_cadastro_cliente2.ivVoltarTela
import kotlinx.android.synthetic.main.activity_tipo_cadastro.*

class CadastroCliente2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cliente2)

        btCadastrar.setOnClickListener {
            val intencaoDeChamada = Intent(this, Login::class.java)
            startActivity(intencaoDeChamada)
        }

        ivVoltarTela.setOnClickListener {
            val intencaoDeChamada = Intent(this, CadastroCliente1::class.java)
            startActivity(intencaoDeChamada)
        }
    }
}