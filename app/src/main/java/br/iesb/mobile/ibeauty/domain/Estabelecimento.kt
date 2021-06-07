package br.iesb.mobile.ibeauty.domain

data class Servico(
    var nome: String
)

data class Estabelecimento(
    var logo: String,
    var latitude: Double,
    var longitude: Double,
    var cidade: String,
    var nome: String,
    var telefone: Int,
    var instagram: String,
    var facebook: String,
    var servicos: List<Servico>,
    var email: String,
    var fotosTrabalhos: String,
    var fotoPerfil: String,
    var descricao: String,
    var domicilio: Boolean
)
