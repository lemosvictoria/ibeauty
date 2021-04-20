package br.iesb.mobile.ibeauty.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.iesb.mobile.ibeauty.R
import kotlinx.android.synthetic.main.activity_recupera_senha1.*

class RecuperaSenha1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recupera_senha1)

        btSolicitarSenha.setOnClickListener {
            val intencaoDeChamada = Intent(this, RecuperaSenha2Activity::class.java)
            startActivity(intencaoDeChamada)
        }
    }
}