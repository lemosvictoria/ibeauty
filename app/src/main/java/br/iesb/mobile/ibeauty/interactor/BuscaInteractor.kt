package br.iesb.mobile.ibeauty.interactor

import android.content.Context
import br.iesb.mobile.ibeauty.domain.Estabelecimento
import br.iesb.mobile.ibeauty.repository.BuscaRepository

class BuscaInteractor (private val context: Context){
    private val repository = BuscaRepository (context)

    fun estabelecimento(callback:(Array<Estabelecimento>) -> Unit){
        repository.estabelecimento(callback)
    }

}