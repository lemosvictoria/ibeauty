package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.mobile.ibeauty.databinding.FragmentChatBotBinding
import br.iesb.mobile.ibeauty.ui.adapter.MessageAdapter
import br.iesb.mobile.ibeauty.viewmodel.ChatBotViewModel
import kotlinx.android.synthetic.main.fragment_chat_bot.*
import java.util.*
import kotlin.random.Random

class ChatBotFragment : Fragment() {
    private val viewModelC: ChatBotViewModel by lazy {
        ViewModelProvider(this).get(ChatBotViewModel::class.java)
    }
    private lateinit var adapter:MessageAdapter
    private lateinit var inputText: TextView
    private lateinit var binding: FragmentChatBotBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBotBinding.inflate(inflater, container, false)
        binding.chat = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputText = textChatbot
        adapter = MessageAdapter(requireActivity().applicationContext)
        initRecyclerView()
        adapter.addMessage("Olá, eu sou a assistente do iBeauty! Aqui eu consigo te ajudar em diversos assuntos, como: Unhas, cabelos, maquiagem, spa, depilação e barbearia. Como posso te ajudar?","chat")
        send.setOnClickListener { sendText() }
    }
    private fun initRecyclerView() {
        messageRecyclerView.layoutManager = LinearLayoutManager(activity)
        messageRecyclerView.adapter = adapter
    }
    private fun sendText() {
        val message = textChatbot.text.toString()

        viewModelC.verifyEmpty(message) { response ->
            if (response == "OK") {
                adapter.addMessage(message, "USER")
                inputText.text = ""

                val data = Date().toString().substring(0, 10).replace(" ", "")
                val random = Random.nextInt(10000000, 1000000000)
                val sessionId = data + random

                viewModelC.sendText(message, "ibeauty@ibeauty.com", sessionId) { chatMessage ->
                    adapter.addMessage(chatMessage, "chat")
                }
            }
        }
    }
}