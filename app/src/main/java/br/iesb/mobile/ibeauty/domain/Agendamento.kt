package br.iesb.mobile.ibeauty.domain

data class Agendamento (
    val servicos: Estabelecimento,
    val data: String? = null,
    val hora: String? = null,
    val telefoneCliente: Cliente,
    val meioAtendimento: Boolean
)