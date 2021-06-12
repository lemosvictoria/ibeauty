package br.iesb.mobile.ibeauty.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.iesb.mobile.ibeauty.data_class.DialogflowRequest
import br.iesb.mobile.ibeauty.interactor.ChatbotInteractor

class ChatBotViewModel (private val app: Application) : AndroidViewModel(app) {
    private val interactor = ChatbotInteractor(app.applicationContext)

    fun sendText(text: String, email: String, sessionId: String, callback: (String) -> Unit) {
        val request = DialogflowRequest(text, email, sessionId)

        interactor.sendText(request) { response ->
            callback(response)
        }
    }

    fun verifyEmpty(text: String, callback: (String) -> Unit) {
        interactor.verifyEmpty(text, callback)
    }
}