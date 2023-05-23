package com.acardona.plantatracker

import android.app.Application
import com.acardona.plantatracker.data.plants
import com.acardona.plantatracker.repositories.PlantRepository

class PlantTrackerApplication : Application() {
    val plantRepository : PlantRepository by lazy {
        PlantRepository(plants)
    }

}