package br.iesb.mobile.ibeauty.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentOnboardingBinding
import br.iesb.mobile.ibeauty.ui.fragment.MainFragment
import br.iesb.mobile.ibeauty.ui.fragment.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.ibeauty.ui.fragment.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.ibeauty.ui.fragment.onboarding.screen.OnboardingThirdFragment
import kotlinx.android.synthetic.main.fragment_onboarding.*

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val listaFragmentos = listOf(
                OnboardingFirstFragment(),
                OnboardingSecondFragment(),
                OnboardingThirdFragment()
        )

        val adaptador = AdaptadorConversacao(listaFragmentos, requireActivity().supportFragmentManager, lifecycle)

        binding.vpOnboarding.adapter = adaptador

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btOnboarding.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fundoLogin, MainFragment(), "Fragmento Principal")
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }
    }
}

class AdaptadorConversacao(
        val listaFragmentos: List<Fragment>,
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle) :
        FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}