package br.iesb.mobile.ibeauty.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.iesb.mobile.ibeauty.databinding.FragmentOnboardingBinding
import br.iesb.mobile.ibeauty.ui.fragment.onboarding.screen.OnboardingFirstFragment
import br.iesb.mobile.ibeauty.ui.fragment.onboarding.screen.OnboardingSecondFragment
import br.iesb.mobile.ibeauty.ui.fragment.onboarding.screen.OnboardingThirdFragment

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

    //terminar navegação botão "vamos lá"

}

class AdaptadorConversacao(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle){

    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}