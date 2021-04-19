package br.iesb.mobile.ibeauty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCadastro.setOnClickListener {
            val intencaoDeChamada = Intent(this, TipoCadastro::class.java)
            startActivity(intencaoDeChamada)
        }

        btLogin.setOnClickListener {
            val intencaoDeChamada = Intent(this, Login::class.java)
            startActivity(intencaoDeChamada)
        }
    }
}