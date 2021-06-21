package br.iesb.mobile.ibeauty.domain

data class Estabelecimento(
    var logoEstabelecimento: String? = null,
    var latitudeEstabelecimento: Double? = null,
    var longitudeEstabelecimento: Double? = null,
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
