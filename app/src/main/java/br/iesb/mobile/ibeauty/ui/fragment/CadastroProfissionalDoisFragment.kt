package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentCadastroProfissionalDoisBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_cadastro_profissional_dois.*

class CadastroProfissionalDoisFragment : Fragment() {

    private lateinit var binding: FragmentCadastroProfissionalDoisBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroProfissionalDoisBinding.inflate(inflater, container, false)
        binding.cadastroProfissionalDois = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //BT Voltar
        btVoltarProf2.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoLogin, CadastroProfissionalUmFragment(), "Fragmento profissional parte 2")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        //BT Cadastrar
        btCadastroProf2.setOnClickListener {
            cadastrar()
        }
    }

    //Funcao Valida Cadastro Profissional
    private fun cadastrar(){
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val confirmaPass = etPassword2.text.toString()

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
                        ?.replace(R.id.fundoLogin, LoginFragment(), "Fragmento profissional parte 2")
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.commit()

            } else {
                Toast.makeText(activity, "Erro no Cadastro! Tente Novamente!", Toast.LENGTH_LONG).show()
            }
        }
    }
}