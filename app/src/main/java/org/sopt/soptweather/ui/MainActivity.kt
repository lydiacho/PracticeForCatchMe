package org.sopt.soptweather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.sopt.soptweather.R
import org.sopt.soptweather.data.CityListInfo
import org.sopt.soptweather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val cityListAdapter: CityListAdapter by lazy{ CityListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initCityList()
    }

    private fun initCityList() {
        val weatherFragment = WeatherFragment()  //액티비티 내 fragment 생성
        //transaction - FragmentManager가 관리할 작업단위 생성
        val transaction = supportFragmentManager.beginTransaction()
        //해당 작업 단위에서 어떤 view, fragment 보여줄 지 설정 및 작업
        transaction.add(R.id.city_list_fragment,weatherFragment)
        transaction.commit()

        //메인뷰와 무관한 데이터 처리 파트
        val inputStream = assets.open("citylist.json")  //inputStream:데이터가 들어오는 통로
        val jsonString =
                runCatching {
                    inputStream.bufferedReader().use { it.readText() }
                }
        //bufferedReader : 개행만 경계로 인식하고 string 데이터를 받음
        //쉽게 말해 버퍼를 통해서, 입력스트림에 담긴 많은 양의 문자 데이터들을 빨리 읽는 함수?
        //use 메소드는 실행후 스트림을 자동으로 닫아주는 것을 보장
        val cityTypeInfo = object : TypeToken<List<CityListInfo>>() {}.type
        val tempdata:List<CityListInfo> = Gson().fromJson(jsonString.getOrNull(), cityTypeInfo)
        cityListAdapter.cityList.addAll(tempdata)
        cityListAdapter.notifyDataSetChanged()

    }

}