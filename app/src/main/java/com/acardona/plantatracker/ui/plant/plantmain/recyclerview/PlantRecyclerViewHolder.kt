package com.acardona.plantatracker.ui.plant.plantmain.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.acardona.plantatracker.data.model.Plant
import com.acardona.plantatracker.databinding.PlantItemBinding

class PlantRecyclerViewHolder(private val binding: PlantItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(plant: Plant, clickListener: (Plant) -> Unit) {
        binding.cardSpecieTextView.text = plant.specie.toString()
        binding.cardPlantColorTextView.text = plant.plantColor.toString()

        binding.plantCard.setOnClickListener {
            clickListener(plant)
        }
    }

}