package br.iesb.mobile.ibeauty.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentHomeBinding
import br.iesb.mobile.ibeauty.databinding.FragmentPerfilClienteBinding
import br.iesb.mobile.ibeauty.ui.activity.AppActivity
import br.iesb.mobile.ibeauty.ui.activity.LoginActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_perfil_cliente.*


class PerfilClienteFragment : Fragment() {

    private lateinit var binding: FragmentPerfilClienteBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPerfilClienteBinding.inflate(inflater, container, false)
        binding.perfil = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btLogout.setOnClickListener {
            signOut()
            val intencaoDeChamada = Intent(activity, LoginActivity::class.java)
            activity?.startActivity(intencaoDeChamada)
        }
    }

    private fun signOut() {
        Firebase.auth.signOut()

        activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoApp, LoginFragment(), "Fragmento de logout")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
    }

}
