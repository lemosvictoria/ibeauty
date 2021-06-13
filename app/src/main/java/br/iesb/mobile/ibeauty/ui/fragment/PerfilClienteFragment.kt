package br.iesb.mobile.ibeauty.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.ibeauty.databinding.FragmentPerfilClienteBinding
import br.iesb.mobile.ibeauty.domain.Cliente
import br.iesb.mobile.ibeauty.ui.activity.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_perfil_cliente.*


class PerfilClienteFragment : Fragment() {

    private lateinit var binding: FragmentPerfilClienteBinding

    var database = FirebaseDatabase.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPerfilClienteBinding.inflate(inflater, container, false)
        binding.perfil = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getClient()

        btLogout.setOnClickListener {
            signOut()
            val intencaoDeChamada = Intent(activity, LoginActivity::class.java)
            activity?.startActivity(intencaoDeChamada)
        }
    }

    private fun signOut() {
        Firebase.auth.signOut()
    }

    private fun getClient() {
        val auth = FirebaseAuth.getInstance()
        val uid = auth.uid

        val query = database.getReference("clientes")

        query.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
                if (uid != null) {
                    val cliente = p0.child(uid).getValue(Cliente::class.java)

                    if (cliente != null) {
                        tvNomeUsuarioPerfil.text = cliente.nomeCliente
                        tvEnderecoPerfil.text = cliente.enderecoCliente
                        tvCepPerfil.text = cliente.cepCliente
                        tvDataNascPerfil.text = cliente.dataNascCliente
                        tvTelefonePerfil.text = cliente.telefoneCliente
                    }
                }
            }
        })
    }

}
