package br.iesb.mobile.ibeauty.domain

data class Cliente(
    var nomeCliente: String? = null,
    var enderecoCliente: String? = null,
    var cepCliente: String? = null,
    var telefoneCliente: String? = null,
    var dataNascCliente: String? = null
)