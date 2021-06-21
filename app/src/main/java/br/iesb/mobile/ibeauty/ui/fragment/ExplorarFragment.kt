package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.ibeauty.databinding.FragmentExplorarBinding

class ExplorarFragment : Fragment() {

    private lateinit var binding: FragmentExplorarBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentExplorarBinding.inflate(inflater, container, false)
        binding.explorar = this
        binding.lifecycleOwner = this

        return binding.root
    }
}