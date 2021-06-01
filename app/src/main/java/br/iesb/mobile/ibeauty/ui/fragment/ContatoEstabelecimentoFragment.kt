package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentContatoEstabelecimentoBinding

class ContatoEstabelecimentoFragment : Fragment() {

    private lateinit var binding: FragmentContatoEstabelecimentoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContatoEstabelecimentoBinding.inflate(inflater, container, false)
        binding.contatoEstabelecimento = this
        binding.lifecycleOwner = this

        return binding.root
    }
}