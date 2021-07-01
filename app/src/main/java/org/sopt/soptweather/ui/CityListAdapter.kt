package org.sopt.soptweather.ui

import android.content.res.AssetManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.soptweather.data.CityInfo
import org.sopt.soptweather.data.Data
import org.sopt.soptweather.databinding.ItemCityBinding

class CityListAdapter :RecyclerView.Adapter<CityListAdapter.CityListViewHolder> () {
    var mPosition = 0   //현재위치의 포지션값 컨트롤 용
    val cityList = mutableListOf<CityInfo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListViewHolder {
        val binding = ItemCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return CityListViewHolder(binding)
    }

    override fun getItemCount(): Int = cityList.size

    fun getPosition():Int {    //현재위치의 포지션값 가져오기
        return mPosition
    }
    fun setPosition(position:Int) {  //현재위치 포지션값 갱신
        mPosition = position
    }
    fun addItem(cityListInfo: CityInfo) {
        cityList.add(cityListInfo)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CityListViewHolder, position: Int) {
        holder.onBind(cityList[position])
        holder.itemView.setOnClickListener { view -> setPosition(position)}
        //클릭 시, 클릭한 아이템의 position을 set하는 메서드 , view -> 가 대체 무슨뜻일까..
        //여기에 상세 화면으로 넘어가는 로직 작성
   }

    class CityListViewHolder(
            private val binding: ItemCityBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(cityListInfo: CityInfo) {
            binding.tvCityName.text = cityListInfo.cityName
            binding.tvCountryName.text = cityListInfo.countryName
        }
    }

}