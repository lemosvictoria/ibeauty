package br.iesb.mobile.ibeauty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_profissional2.*

class CadastroProfissional2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_profissional2)

        btVoltarProf2.setOnClickListener {
            val intencaoChamada = Intent(this, CadastroProfissional1::class.java)
            startActivity(intencaoChamada)
        }
    }
}