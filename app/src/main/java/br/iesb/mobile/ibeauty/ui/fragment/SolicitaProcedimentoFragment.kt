package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentSolicitaProcedimentoBinding

class SolicitaProcedimentoFragment : Fragment() {

    private lateinit var binding: FragmentSolicitaProcedimentoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                savedInstanceState: Bundle? ): View? {
        binding = FragmentSolicitaProcedimentoBinding.inflate(inflater, container, false)
        binding.solicitacao = this
        binding.lifecycleOwner = this

        return binding.root
    }

}