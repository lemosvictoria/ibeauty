package br.iesb.mobile.ibeauty.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.domain.Estabelecimento
import br.iesb.mobile.ibeauty.ui.fragment.PerfilEstabelecimentoFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.busca_estabelecimento_card.view.*

class BuscaAdapter(
    var lista: MutableList<Estabelecimento>,
    val activity: FragmentActivity?,
    var listaFiltrada: MutableList<Estabelecimento>
) : RecyclerView.Adapter<BuscaAdapter.BuscaViewHolder>(), Filterable {
    class BuscaViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val nomeestab: TextView = item.nomeEstab
        val imgestab: ImageView = item.imgEstab
        val localiza: TextView = item.cidadeEstab
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuscaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.busca_estabelecimento_card, parent, false)
        return BuscaViewHolder(view)
    }


    override fun onBindViewHolder(holder: BuscaViewHolder, position: Int) {
        holder.localiza.text = listaFiltrada[position].cidadeEstabelecimento
        holder.nomeestab.text = listaFiltrada[position].nomeEstabelecimento
        Picasso.get().load(listaFiltrada[position].logoEstabelecimento).into(holder.imgestab)

        holder.itemView.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoApp, PerfilEstabelecimentoFragment(listaFiltrada[position]), "Fragmento de lista de busca")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.addToBackStack(null)
                ?.commit()
        }

    }

    override fun getItemCount(): Int {
        return listaFiltrada.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val resultadosFiltrados = FilterResults()
                if (constraint == null || constraint.isEmpty()) {
                    resultadosFiltrados.count = lista.size
                    resultadosFiltrados.values = lista
                } else {
                    val texto = constraint.toString().toUpperCase()
                    val resultados = ArrayList<Estabelecimento>()

                    for (elemento in lista) {
                        val new = if (elemento.nomeEstabelecimento != null) {
                            elemento.nomeEstabelecimento as String
                        } else {
                            ""
                        }
                        val new2 = if (elemento.cidadeEstabelecimento != null) {
                            elemento.cidadeEstabelecimento as String
                        } else {
                            ""
                        }
                        if (new.toUpperCase().contains(texto) || new2.toUpperCase().contains(texto)) {
                            resultados.add(elemento)
                        }

                        resultadosFiltrados.count = resultados.size
                        resultadosFiltrados.values = resultados
                    }
                }
                return resultadosFiltrados
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                if (results?.values != null) {
                    @Suppress("UNCHECKED_CAST")
                    listaFiltrada = results.values as ArrayList<Estabelecimento>
                    notifyDataSetChanged()
                }
            }
        }
    }
}