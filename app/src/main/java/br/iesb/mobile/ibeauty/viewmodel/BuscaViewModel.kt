package br.iesb.mobile.ibeauty.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.iesb.mobile.ibeauty.domain.Estabelecimento
import br.iesb.mobile.ibeauty.interactor.BuscaInteractor

class BuscaViewModel (private val app:Application):AndroidViewModel (app){
    private val interactor = BuscaInteractor (app.applicationContext)
    val estabelecimentos = MutableLiveData<MutableList <Estabelecimento>>()

    fun estabelecimento (){
        interactor.estabelecimento { arrayestabelecimento ->
            val novalista = mutableListOf<Estabelecimento>()
            arrayestabelecimento.forEach {e ->
                novalista.add(e)
            }
            estabelecimentos.value = novalista
        }
    }
}