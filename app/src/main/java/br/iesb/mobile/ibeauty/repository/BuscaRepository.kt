package br.iesb.mobile.ibeauty.repository

import android.content.Context
import br.iesb.mobile.ibeauty.domain.Estabelecimento
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BuscaRepository (context:Context){
    var database = FirebaseDatabase.getInstance()

    fun estabelecimento(callback:(Array<Estabelecimento>) -> Unit ){
    val reference = database.getReference("estabelecimentos")
        reference.addListenerForSingleValueEvent(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lista = snapshot.children
                val listafinal = mutableListOf<Estabelecimento>()
                lista.forEach { no ->
                    val estab = no.getValue(Estabelecimento::class.java)
                    if (estab != null){
                        listafinal.add(estab)
                    }
                }
                callback(listafinal.toTypedArray())
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }


}

