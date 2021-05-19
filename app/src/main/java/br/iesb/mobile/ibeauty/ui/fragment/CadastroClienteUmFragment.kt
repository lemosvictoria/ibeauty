package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentCadastroClienteUmBinding
import kotlinx.android.synthetic.main.fragment_cadastro_cliente_um.*

class CadastroClienteUmFragment : Fragment() {

    private lateinit var binding: FragmentCadastroClienteUmBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroClienteUmBinding.inflate(inflater, container, false)
        binding.cadastroClienteUm = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btCadastroProx.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoLogin, CadastroClienteDoisFragment(), "Fragmento de cadastro cliente")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        btVoltarTela.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoLogin, TipoCadastroFragment(), "Fragmento de cadastro cliente")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }
    }

}