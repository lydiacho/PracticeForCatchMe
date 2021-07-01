package org.sopt.soptweather.ui

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONArray
import org.sopt.soptweather.R
import org.sopt.soptweather.data.CityInfo
import org.sopt.soptweather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val weatherFragment = WeatherFragment()  //액티비티 내 fragment 생성
        //transaction - FragmentManager가 관리할 작업단위 생성
        val transaction = supportFragmentManager.beginTransaction()
        //해당 작업 단위에서 어떤 view, fragment 보여줄 지 설정 및 작업
        transaction.add(R.id.city_list_fragment,weatherFragment)
        transaction.commit()


        //여기가 아니라고 생각하는데...리스트의 요소를 구성하는거라 어댑터에 들어가야할 것 같은데 어떻게 넣어야할지 모르겠어서 일단 냅다 이곳에 추가합니다..
        val assetManager = resources.assets
        val inputStream= assetManager.open("posts.json")  //inputStream:데이터가 들어오는 통로
        val jsonString = inputStream.bufferedReader( ).use { it.readText() }
//bufferedReader : 개행만 경계로 인식하고 string 데이터를 받음
//쉽게 말해 버퍼를 통해서, 입력스트림에 담긴 많은 양의 문자 데이터들을 빨리 읽는 함수?
//use 메소드는 실행후 스트림을 자동으로 닫아주는 것을 보장

        val jArray = JSONArray()

        for (i in 0 until jArray.length()) {
            val obj = jArray.getJSONObject(i)  //각 배열칸의 옵젝트 분리
            val name = obj.getString("name")
            val country = obj.getString("country")

            //리스트에 이 변수들 넣기
            val tempData = CityInfo(
                    cityName = name,
                    countryName = country)
            cityList.add(tempData)
            //cityList가 어댑터에서 선언한 변수라 여기서는 쓸 수가 없는데... 그런데...ㅠㅠ
        }

    }

}