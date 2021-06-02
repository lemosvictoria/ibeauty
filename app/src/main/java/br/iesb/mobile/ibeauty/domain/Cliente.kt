package br.iesb.mobile.ibeauty.domain

data class Cliente (
    var nomeCliente: String,
    var dataNasc: String,
    var enderecoCliente: String,
    var cepCliente: String,
    var telefoneCliente: Int,
    var emailCliente: String
)