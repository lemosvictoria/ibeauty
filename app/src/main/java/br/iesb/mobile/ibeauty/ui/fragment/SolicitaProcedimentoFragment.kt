package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentSolicitaProcedimentoBinding
import kotlinx.android.synthetic.main.fragment_solicita_procedimento.*

class SolicitaProcedimentoFragment : Fragment() {

    private lateinit var binding: FragmentSolicitaProcedimentoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle? ): View {
        binding = FragmentSolicitaProcedimentoBinding.inflate(inflater, container, false)
        binding.solicitacao = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btAgendamento.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoApp, ConfirmaSolicitacaoAgendamentoFragment(), "Fragmento de agendamento")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }

    }



}