package com.acardona.plantatracker.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.acardona.plantatracker.PlantTrackerApplication
import com.acardona.plantatracker.data.model.Plant
import com.acardona.plantatracker.repositories.PlantRepository

class PlantViewModel(private val repository: PlantRepository): ViewModel() {
    // variables de la planta
    var specie = MutableLiveData("")
    var plantColor = MutableLiveData("")

    //variable del estado
    var status = MutableLiveData("")

    fun addPlants(plant: Plant) = repository.addPlants(plant)

    fun getPlants() = repository.getPlants()

    //funcion para validar la data

    private fun validateData() : Boolean {
        when {
            specie.value.isNullOrEmpty() -> return false
            plantColor.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun createPlant() {
        if (!validateData()){
            status.value = WRONG_DATA
            return
        }
        val newPlant = Plant(
            specie.value.toString(),
            plantColor.value.toString()
        )
        addPlants(newPlant)
        status.value = PLANT_CREATED
    }

    // funcion para limpiar la data
    fun clearData() {
        specie.value = ""
        plantColor.value = ""
    }

    // funcion para poner el estado en BASE_STATE
    fun clearStatus() {
        status.value = BASE_STATE
    }

    //funcion para utilizar la data de una planta
    fun setSelectedPlant(plant: Plant) {
        specie.value = plant.specie
        plantColor.value = plant.plantColor
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as PlantTrackerApplication
                PlantViewModel(app.plantRepository)
            }
        }

        const val WRONG_DATA = "wrong data"
        const val PLANT_CREATED = "plant created"
        const val BASE_STATE = ""
    }
}