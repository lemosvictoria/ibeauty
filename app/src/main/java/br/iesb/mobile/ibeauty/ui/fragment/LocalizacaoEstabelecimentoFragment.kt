package br.iesb.mobile.ibeauty.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.ibeauty.R
import br.iesb.mobile.ibeauty.databinding.FragmentLocalizacaoEstabelecimentoBinding
import br.iesb.mobile.ibeauty.domain.Estabelecimento
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class LocalizacaoEstabelecimentoFragment(private val estabelecimento: Estabelecimento) : Fragment() {

    private lateinit var binding: FragmentLocalizacaoEstabelecimentoBinding

    private val callback = OnMapReadyCallback { googleMap ->

        val location = LatLng(estabelecimento.latitudeEstabelecimento!!,
            estabelecimento.longitudeEstabelecimento!!
        )
        googleMap.addMarker(
            MarkerOptions()
            .position(location)
            .title(estabelecimento.nomeEstabelecimento))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 13f))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocalizacaoEstabelecimentoBinding.inflate(inflater, container, false)
        binding.localizacaoEstabelecimento = this
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}