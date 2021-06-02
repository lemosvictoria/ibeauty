package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.iesb.mobile.ibeauty.databinding.FragmentChatBotBinding

class ChatBotFragment : Fragment() {

    private lateinit var binding: FragmentChatBotBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBotBinding.inflate(inflater, container, false)
        binding.chat = this
        binding.lifecycleOwner = this

        return binding.root
    }
}