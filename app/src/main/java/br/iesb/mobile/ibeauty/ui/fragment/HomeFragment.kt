package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_main.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.home = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btVerMais.setOnClickListener {
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoApp, ExplorarFragment(), "Fragmento home")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        ivCabelo.setOnClickListener{
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoApp, BuscaFragment(), "Fragmento home")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        ivUnhas.setOnClickListener{
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoApp, BuscaFragment(), "Fragmento home")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        ivSpa.setOnClickListener{
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoApp, BuscaFragment(), "Fragmento home")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        ivMaquiagem.setOnClickListener{
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoApp, BuscaFragment(), "Fragmento home")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        ivBarbearia.setOnClickListener{
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoApp, BuscaFragment(), "Fragmento home")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }

        ivDepilacao.setOnClickListener{
            activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.fundoApp, BuscaFragment(), "Fragmento home")
                    ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    ?.commit()
        }
    }
}