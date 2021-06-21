package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.ibeauty.databinding.FragmentContatoEstabelecimentoBinding
import br.iesb.mobile.ibeauty.domain.Estabelecimento
import kotlinx.android.synthetic.main.fragment_contato_estabelecimento.*


class ContatoEstabelecimentoFragment(private val estabelecimento: Estabelecimento) : Fragment() {

    private lateinit var binding: FragmentContatoEstabelecimentoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContatoEstabelecimentoBinding.inflate(inflater, container, false)
        binding.contatoEstabelecimento = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvTelefoneEstab.text = estabelecimento.telefoneEstabelecimento
        tvInstagramEstab.text = estabelecimento.instagramEstabelecimento
        tvFacebookEstab.text = estabelecimento.facebookEstabelecimento
        tvEmailEstab.text = estabelecimento.emailEstabelecimento
    }
}