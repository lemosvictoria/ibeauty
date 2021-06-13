package br.iesb.mobile.ibeauty.domain

data class Estabelecimento(
    var logoEstabelecimento: String? = null,
    var latitudeEstabelecimento: String? = null,
    var longitudeEstabelecimento: String? = null,
    var cidadeEstabelecimento: String? = null,
    var nomeEstabelecimento: String? = null,
    var telefoneEstabelecimento: String? = null,
    var instagramEstabelecimento: String? = null,
    var facebookEstabelecimento: String? = null,
    var servicosEstabelecimento: List<String>? = null,
    var emailEstabelecimento: String? = null,
    var descricaoEstabelecimento: String? = null,
    var domicilioEstabelecimento: Boolean? = null
)
