package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentPerfilEstabelecimentoBinding
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_perfil_estabelecimento.*

class PerfilEstabelecimentoFragment : Fragment() {

    private lateinit var binding: FragmentPerfilEstabelecimentoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPerfilEstabelecimentoBinding.inflate(inflater, container, false)
        binding.estabelecimento = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btContatos.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoApp, ContatoEstabelecimentoFragment(), "Fragmento perfil estabelecimento")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.addToBackStack(null)
                ?.commit()
        }

        btLocalizacao.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoApp, LocalizacaoEstabelecimentoFragment(), "Fragmento perfil estabelecimento")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.addToBackStack(null)
                ?.commit()
        }

        btSolicitaHorario.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoApp, SolicitaProcedimentoFragment(), "Fragmento perfil estabelecimento")
                ?.addToBackStack(null)
                ?.commit()
        }

    }

}