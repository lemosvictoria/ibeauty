package br.iesb.mobile.ibeauty.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.ui.activity.AppActivity
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
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoLogin, MainFragment(), "Fragmento de login")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        //Bt redefinir senha
        tvEsqueceuSenha.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoLogin, ForgotFragment(), "Fragmento de login")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        //Autentica Firebase
        btLogin.setOnClickListener {
            val email = emailLogin.text.toString()
            val password = senhaLogin.text.toString()
            val auth = FirebaseAuth.getInstance()

            val taskDeLogin = auth.signInWithEmailAndPassword(email, password)
            taskDeLogin.addOnCompleteListener { resultado ->
                if (resultado.isSuccessful){
                    val intencaoDeChamada = Intent(activity, AppActivity::class.java)
                    activity?.startActivity(intencaoDeChamada)
                }else{
                    Toast.makeText(activity,"E-mail e/ou Senha Incorretos!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}