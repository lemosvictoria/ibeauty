package br.iesb.mobile.ibeauty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro_profissional1.*

class CadastroProfissional1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_profissional1)

        btCadastroProf1.setOnClickListener {
            val intencaoChamada = Intent (this, CadastroProfissional2::class.java)
            startActivity(intencaoChamada)
        }

    }
}