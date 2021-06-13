package br.iesb.mobile.ibeauty.ui.adapter

import android.graphics.BitmapFactory
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.domain.Estabelecimento
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.busca_card.view.*
import kotlinx.android.synthetic.main.busca_estabelecimento_card.view.*

class BuscaAdapter(
    var lista: MutableList<Estabelecimento>,
    var listaFiltrada: MutableList<Estabelecimento>
) : RecyclerView.Adapter<BuscaAdapter.BuscaViewHolder>(), Filterable {
    class BuscaViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        // val logo: ImageView = item.logo_busca
        // val loja: TextView = item.loja_busca

        //busca_estabelecimento_card
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
        //holder.loja.text = listaFiltrada[position].nomeEstabelecimento

        //val byteArray = Base64.decode(listaFiltrada[position].logoEstabelecimento, Base64.DEFAULT)
        //val image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
        //holder.logo.setImageBitmap(image)

        //busca_estabelecimento_card
        holder.localiza.text = listaFiltrada[position].cidadeEstabelecimento
        holder.nomeestab.text = listaFiltrada[position].nomeEstabelecimento
        //   val byteArraylogo = Base64.decode(listaFiltrada[position].logoEstabelecimento, Base64.DEFAULT)
        //   val logoestab = BitmapFactory.decodeByteArray(byteArraylogo, 0, byteArraylogo.size)
        //   holder.imgestab.setImageBitmap(logoestab)
        Picasso.get().load(listaFiltrada[position].logoEstabelecimento).into(holder.imgestab)
    }

    override fun getItemCount(): Int {
        return lista.size
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
                        if (elemento.nomeEstabelecimento?.contains(texto) == true) {
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