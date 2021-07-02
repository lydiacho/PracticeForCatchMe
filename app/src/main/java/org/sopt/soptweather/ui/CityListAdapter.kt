package org.sopt.soptweather.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import org.sopt.soptweather.data.CityListInfo
import org.sopt.soptweather.databinding.ItemCityBinding

class CityListAdapter :RecyclerView.Adapter<CityListAdapter.CityListViewHolder> () {
    val cityList = mutableListOf<CityListInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListViewHolder {
        val binding = ItemCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        return CityListViewHolder(binding)
    }

    override fun getItemCount(): Int = cityList.size

    override fun onBindViewHolder(holder: CityListViewHolder, position: Int) {
        holder.onBind(cityList[position])
   }

    class CityListViewHolder(private val binding: ItemCityBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(cityListInfo: CityListInfo) {
            binding.tvCityName.text = cityListInfo.city
            binding.tvCountryName.text = cityListInfo.country

            itemView.setOnClickListener {
                val intent = Intent(context, CityDetailActivity::class.java) {
                    //putextra로 데이터 보내야함 (id)
                }
                startActivity(intent)
            }
        }

    }

}