package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.ibeauty.databinding.FragmentConfirmaSolicitacaoAgendamentoBinding

class ConfirmaSolicitacaoAgendamentoFragment : Fragment() {

    private lateinit var binding: FragmentConfirmaSolicitacaoAgendamentoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmaSolicitacaoAgendamentoBinding.inflate(inflater, container, false)
        binding.confirmaSolicitacao = this
        binding.lifecycleOwner = this

        return binding.root
    }
}