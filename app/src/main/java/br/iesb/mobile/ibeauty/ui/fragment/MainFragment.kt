package br.iesb.mobile.ibeauty.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentMainBinding
import br.iesb.mobile.ibeauty.ui.activity.AppActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.main = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btLogin.setOnClickListener {
            if (auth.currentUser == null) {
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoLogin, LoginFragment(), "Fragmento Principal")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
            } else {
                val intencaoDeChamada = Intent(activity, AppActivity::class.java)
                activity?.startActivity(intencaoDeChamada)
            }
        }

        btCadastro.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoLogin, TipoCadastroFragment(), "Fragmento Principal")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }
    }
}