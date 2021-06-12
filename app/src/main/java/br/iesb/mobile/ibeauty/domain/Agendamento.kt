package br.iesb.mobile.ibeauty.domain

data class Agendamento (
    val servicos: Estabelecimento,
    val data: String,
    val hora: String,
    val telefoneCliente: Cliente,
    val meioAtendimento: Boolean
)