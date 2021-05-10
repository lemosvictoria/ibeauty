package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentLocalizacaoEstabelecimentoBinding

class LocalizacaoEstabelecimentoFragment : Fragment() {

    private lateinit var binding: FragmentLocalizacaoEstabelecimentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocalizacaoEstabelecimentoBinding.inflate(inflater, container, false)
        binding.localizacaoEstabelecimento = this
        binding.lifecycleOwner = this

        return binding.root
    }
}