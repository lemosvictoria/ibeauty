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
import br.iesb.mobile.ibeauty.databinding.FragmentCadastroClienteUmBinding
import br.iesb.mobile.ibeauty.domain.Cliente
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_cadastro_cliente_um.*

class CadastroClienteUmFragment : Fragment() {

    private lateinit var binding: FragmentCadastroClienteUmBinding

    lateinit var tvNome: EditText
    lateinit var tvEndereco: EditText
    lateinit var tvTelefone: EditText
    lateinit var tvCep: EditText
    lateinit var tvDataDeNascimento: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCadastroClienteUmBinding.inflate(inflater, container, false)
        binding.cadastroClienteUm = this
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

        btCadastroProx.setOnClickListener {
            salvar()
        }

        btVoltarTela.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoLogin, TipoCadastroFragment(), "Fragmento de cadastro cliente")
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
            val reference = FirebaseDatabase.getInstance().getReference("clientes")
            val idCliente = reference.push().key

            val cliente =
                Cliente(
                    idCliente.toString(),
                    nomeCliente,
                    enderecoCliente,
                    cepCliente,
                    telefoneCliente,
                    dataNascCliente,
                )

            reference.child(idCliente.toString()).setValue(cliente)
                .addOnCompleteListener { resultado ->
                    if (resultado.isSuccessful) {
                        activity?.supportFragmentManager
                            ?.beginTransaction()
                            ?.replace(
                                R.id.fundoLogin,
                                CadastroClienteDoisFragment(),
                                "Fragmento de cadastro cliente"
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