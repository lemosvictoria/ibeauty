package br.iesb.mobile.ibeauty.domain

data class Servico(
    var nome: String
)

data class Estabelecimento(
    var logoEstabelecimento: String,
    var latitudeEstabelecimento: Double,
    var longitudeEstabelecimento: Double,
    var cidadeEstabelecimento: String,
    var nomeEstabelecimento: String,
    var telefoneEstabelecimento: String,
    var instagramEstabelecimento: String,
    var facebookEstabelecimento: String,
    var servicosEstabelecimento: List<Servico>,
    var emailEstabelecimento: String,
    var fotosTrabalhosEstabelecimento: String,
    var descricaoEstabelecimento: String,
    var domicilioEstabelecimento: Boolean
)
