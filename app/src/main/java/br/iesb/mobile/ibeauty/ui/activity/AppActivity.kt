package br.iesb.mobile.ibeauty.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        supportFragmentManager
                .beginTransaction()
//                .replace(R.id.fundoApp, HomeFragment(), "Home Fragment")
                .replace(R.id.fundoApp, MenuFragment(), "Menu Fragment")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
    }
}