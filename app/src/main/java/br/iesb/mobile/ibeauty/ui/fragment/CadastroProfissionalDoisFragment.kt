package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.iesb.mobile.ibeauty.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_cadastro_profissional_dois.*

class CadastroProfissionalDoisFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_profissional_dois, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //BT Voltar
        btVoltarProf2.setOnClickListener {
            activity?.finish()
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
                //terminar navegação
            } else {
                Toast.makeText(activity, "Erro no Cadastro! Tente Novamente!", Toast.LENGTH_LONG).show()
            }
        }
    }
}