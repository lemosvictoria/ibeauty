package br.iesb.mobile.ibeauty.repository.dto

data class ChatbotDTO(
    val queryResult: QueryResult? = null
)
data class QueryResult(
    val fulfillmentText: String? = null
)
