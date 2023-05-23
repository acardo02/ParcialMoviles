package com.acardona.plantatracker.repositories

import com.acardona.plantatracker.data.model.Plant


class PlantRepository(private val plants: MutableList<Plant>) {

    fun getPlants() = plants

    fun addPlants(plant: Plant) = plants.add(plant)
}