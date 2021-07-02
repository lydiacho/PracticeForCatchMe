package org.sopt.soptweather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.soptweather.databinding.FragmentWeatherBinding

class WeatherFragment: Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding ?: error("View 를 참조하기 위해 binding 이 초기화 되지 않았습니다.")
    private val cityListAdapter: CityListAdapter by lazy{ CityListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCityList.adapter = cityListAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}