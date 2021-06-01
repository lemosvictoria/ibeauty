package br.iesb.mobile.ibeauty.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.ui.fragment.*
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.android.synthetic.main.activity_app.*

@AndroidEntryPoint
@WithFragmentBindings
class AppActivity : AppCompatActivity() {

    private val HomeFragment = HomeFragment()
    private val PerfilClienteFragment = PerfilClienteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        replaceFragment(HomeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.btHome -> replaceFragment(HomeFragment)
                R.id.btPerfil -> replaceFragment(PerfilClienteFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fundoApp, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}