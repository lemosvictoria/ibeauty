package br.iesb.mobile.ibeauty.interactor

import android.content.Context
import br.iesb.mobile.ibeauty.data_class.DialogflowRequest
import br.iesb.mobile.ibeauty.repository.ChatbotRepository

class ChatbotInteractor (context: Context) {
    private val repository = ChatbotRepository(context, "https://dialogflow-ibeauty.herokuapp.com/")

    fun sendText(request: DialogflowRequest, callback: (String) -> Unit) {
        repository.sendText(request, callback)
    }

    fun verifyEmpty(text: String, callback: (String) -> Unit) {
        if (text.isEmpty()) {
            callback("EMPTY")
        } else {
            callback("OK")
        }
    }
}
