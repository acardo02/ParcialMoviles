package com.acardona.plantatracker.ui.plant.plantmain.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.acardona.plantatracker.data.model.Plant
import com.acardona.plantatracker.databinding.PlantItemBinding

class PlantRecyclerViewAdapter(private val clickListener : (Plant) -> Unit) : RecyclerView.Adapter<PlantRecyclerViewHolder>(){

    private val plants = ArrayList<Plant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantRecyclerViewHolder {
        val binding = PlantItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int = plants.size ?: 0

    override fun onBindViewHolder(holder: PlantRecyclerViewHolder, position: Int) {
        val plant = plants[position]
        holder.bind(plant, clickListener)
    }

    fun setData(plantsList: List<Plant>) {
        plants.clear()
        plants.addAll(plantsList)
    }


}