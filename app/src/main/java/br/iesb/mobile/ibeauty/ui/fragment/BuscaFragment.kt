package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.ui.adapter.BuscaAdapter
import kotlinx.android.synthetic.main.fragment_busca.*


class BuscaFragment : Fragment() {
    lateinit var adapter: BuscaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_busca, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BuscaAdapter(mutableListOf(), mutableListOf())
        lista_lojas.layoutManager = LinearLayoutManager(activity?.applicationContext)
        lista_lojas.adapter = adapter
//        TODO("Trazer informações das lojas no firebase")


        pesquisarLoja.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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