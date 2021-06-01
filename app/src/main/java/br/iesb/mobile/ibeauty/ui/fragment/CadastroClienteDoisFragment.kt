package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentCadastroClienteDoisBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_cadastro_cliente_dois.*

class CadastroClienteDoisFragment : Fragment() {

    private lateinit var binding: FragmentCadastroClienteDoisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroClienteDoisBinding.inflate(inflater, container, false)
        binding.cadastroClienteDois = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //BT Voltar
        btVoltarTela.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoLogin, CadastroClienteUmFragment(), "Fragmento cliente parte 2")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        //BT Cadastrar
        btCadastrar.setOnClickListener {
            cadastrar()
        }
    }

    //Funcao Valida Cadastro Cliente
    private fun cadastrar(){
        val email = tvEmailCadastro.text.toString()
        val password = tvSenhaCadastro.text.toString()
        val confirmaPass = tvConfirmarSenha.text.toString()

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
                        ?.replace(R.id.fundoLogin, LoginFragment(), "Fragmento cliente parte 2")
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.commit()

            } else {
                Toast.makeText(activity, "Erro no Cadastro! Tente Novamente!", Toast.LENGTH_LONG).show()
            }
        }
    }
}