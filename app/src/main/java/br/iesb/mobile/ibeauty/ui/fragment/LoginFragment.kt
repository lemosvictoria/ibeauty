package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.iesb.mobile.ibeauty.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Bt Voltar
        btVoltarTela.setOnClickListener {
            activity?.finish()
        }

        //Bt redefinir senha
        tvEsqueceuSenha.setOnClickListener {
            //terminar navegação
        }

        //Autentica Firebase
        btLogin.setOnClickListener {
            val email = emailLogin.text.toString()
            val password = senhaLogin.text.toString()
            val auth = FirebaseAuth.getInstance()

            val taskDeLogin = auth.signInWithEmailAndPassword(email, password)
            taskDeLogin.addOnCompleteListener { resultado ->
                if (resultado.isSuccessful){
                    //terminar navegação
                }else{
                    Toast.makeText(activity,"E-mail e/ou Senha Incorretos!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}