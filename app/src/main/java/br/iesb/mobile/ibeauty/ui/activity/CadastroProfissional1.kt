package br.iesb.mobile.ibeauty.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.ibeauty.R
import kotlinx.android.synthetic.main.activity_cadastro_profissional1.*

class CadastroProfissional1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_profissional1)

        btCadastroProf1.setOnClickListener {
            val intencaoChamada = Intent (this, CadastroProfissional2::class.java)
            startActivity(intencaoChamada)
        }

        btVoltarProf1.setOnClickListener {
            finish()
        }

    }
}