 package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentCadastroClienteDoisBinding
import br.iesb.mobile.ibeauty.domain.Cliente
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_cadastro_cliente_dois.*
import kotlinx.android.synthetic.main.fragment_cadastro_cliente_dois.btVoltarTela

class CadastroClienteDoisFragment : Fragment() {

    private lateinit var binding: FragmentCadastroClienteDoisBinding

    lateinit var tvNome: EditText
    lateinit var tvEndereco: EditText
    lateinit var tvTelefone: EditText
    lateinit var tvCep: EditText
    lateinit var tvDataDeNascimento: EditText

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

        tvNome = view.findViewById(R.id.tvNome)
        tvEndereco = view.findViewById(R.id.tvEndereco)
        tvCep = view.findViewById(R.id.tvCep)
        tvDataDeNascimento = view.findViewById(R.id.tvDataDeNascimento)
        tvTelefone = view.findViewById(R.id.tvTelefone)

        btCadastrar.setOnClickListener {
            salvar()
        }

        btVoltarTela.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoLogin, TipoCadastroFragment(), "Fragmento de cadastro cliente parte 2")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }
    }

    private fun validaCampos(): Boolean {

        val nomeCliente = tvNome.text.toString().trim()
        val enderecoCliente = tvEndereco.text.toString().trim()
        val cepCliente = tvCep.text.toString().trim()
        val telefoneCliente = tvTelefone.text.toString().trim()
        val dataNascCliente = tvDataDeNascimento.text.toString().trim()

        var validado = true

        if (nomeCliente.isEmpty()) {
            tvNome.error = "Por favor, digite o seu nome!"
            validado = false
        }

        if (enderecoCliente.isEmpty()) {
            tvEndereco.error = "Por favor, digite o seu endereço!"
            validado = false
        }

        if (cepCliente.isEmpty()) {
            tvCep.error = "Por favor, digite o seu CEP!"
            validado = false
        }

        if (telefoneCliente.isEmpty()) {
            tvTelefone.error = "Por favor, digite o seu telefone de contato!"
            validado = false
        }

        if (dataNascCliente.isEmpty()) {
            tvDataDeNascimento.error = "Por favor, digite a sua data de nascimento!"
            validado = false
        }

        return validado
    }

    private fun salvar() {

        val nomeCliente = tvNome.text.toString().trim()
        val enderecoCliente = tvEndereco.text.toString().trim()
        val cepCliente = tvCep.text.toString().trim()
        val telefoneCliente = tvTelefone.text.toString().trim()
        val dataNascCliente = tvDataDeNascimento.text.toString().trim()

        validaCampos()

        if (validaCampos()) {
            val auth = FirebaseAuth.getInstance()
            val uid = auth.uid

            val reference = FirebaseDatabase.getInstance().getReference("clientes/$uid")

            val cliente =
                Cliente(
                    nomeCliente,
                    enderecoCliente,
                    cepCliente,
                    telefoneCliente,
                    dataNascCliente,
                )

            reference.setValue(cliente)

            .addOnCompleteListener { resultado ->
                if (resultado.isSuccessful) {
                    activity?.supportFragmentManager
                        ?.beginTransaction()
                        ?.replace(
                            R.id.fundoLogin,
                            LoginFragment(),
                            "Fragmento de cadastro cliente parte 2"
                        )
                        ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        ?.addToBackStack(null)
                        ?.commit()
                } else {
                    Toast.makeText(
                        activity,
                        "Não conseguimos salvar os seus dados! Por favor, insira-os novamente!",
                        Toast.LENGTH_LONG
                    ).show()
                    salvar()
                }
            }
        }
    }
}