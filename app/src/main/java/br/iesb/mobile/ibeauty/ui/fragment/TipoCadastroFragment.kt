package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentTipoCadastroBinding
import kotlinx.android.synthetic.main.fragment_tipo_cadastro.*


class TipoCadastroFragment : Fragment() {

    private lateinit var binding: FragmentTipoCadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTipoCadastroBinding.inflate(inflater, container, false)
        binding.tipoCadastro = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btVoltarTela.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoLogin, MainFragment(), "Fragmento de tipo de cadastro")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }

        linkLogin.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(
                    R.id.fundoLogin,
                    LoginFragment(),
                    "Fragmento de tipo de cadastro"
                )
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.addToBackStack(null)
                ?.commit()
        }

        btTipoCliente.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(
                    R.id.fundoLogin,
                    CadastroClienteFragment(),
                    "Fragmento de tipo de cadastro"
                )
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.addToBackStack(null)
                ?.commit()
        }

        btTipoProfissional.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(
                    R.id.fundoLogin,
                    CadastroProfissionalUmFragment(),
                    "Fragmento de tipo de cadastro"
                )
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}