package br.iesb.mobile.ibeauty.domain

data class Cliente(
    val idCliente: String,
    val nomeCliente: String,
    val enderecoCliente: String,
    val cepCliente: String,
    val telefoneCliente: String,
    val dataNascCliente: String
//    var emailCliente: String,
//    var senhaCliente: String,
)