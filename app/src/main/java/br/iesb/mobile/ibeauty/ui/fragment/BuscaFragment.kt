package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.mobile.ibeauty.databinding.FragmentBuscaBinding
import br.iesb.mobile.ibeauty.ui.adapter.BuscaAdapter
import kotlinx.android.synthetic.main.fragment_busca.*


class BuscaFragment : Fragment() {
    lateinit var adapter: BuscaAdapter
    private lateinit var binding: FragmentBuscaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuscaBinding.inflate(inflater, container, false)
        binding.busca = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BuscaAdapter(mutableListOf(), mutableListOf())
        lista_estabelecimentos.layoutManager = LinearLayoutManager(activity?.applicationContext)
        lista_estabelecimentos.adapter = adapter
//      TODO("Trazer informações dos estabelecimentos no firebase")

        pesquisarEstabelecimento.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }

        })
    }

}