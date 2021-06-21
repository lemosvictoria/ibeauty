package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentCadastroClienteBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_cadastro_cliente.*
import kotlinx.android.synthetic.main.fragment_cadastro_cliente.btVoltarTela

class CadastroClienteFragment : Fragment() {

    private lateinit var binding: FragmentCadastroClienteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroClienteBinding.inflate(inflater, container, false)
        binding.cadastroCliente = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btProximo.setOnClickListener {
            cadastrar()
        }

        btVoltarTela.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoLogin, TipoCadastroFragment(), "Fragmento de cadastro cliente parte 1")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }
    }

    //Funcao Valida Cadastro Cliente
    private fun cadastrar(){
        val email = tvEmailCadastro.text.toString().trim()
        val password = tvSenhaCadastro.text.toString().trim()
        val confirmaPass = tvConfirmarSenha.text.toString().trim()

        if (password != confirmaPass){
            Toast.makeText(activity, "Senhas não conferem!", Toast.LENGTH_LONG).show()
            return
        }

        val auth = FirebaseAuth.getInstance()
        val taskDeLogin = auth.createUserWithEmailAndPassword(email, password)

        taskDeLogin.addOnCompleteListener { resultado ->
            if (resultado.isSuccessful) {
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoLogin, CadastroClienteDoisFragment(), "Fragmento cliente parte 1")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()

            } else {
                Toast.makeText(activity, "Erro no Cadastro! Tente Novamente!", Toast.LENGTH_LONG).show()
            }
        }
    }
}