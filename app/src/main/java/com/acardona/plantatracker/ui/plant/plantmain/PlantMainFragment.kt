package com.acardona.plantatracker.ui.plant.plantmain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.acardona.plantatracker.R
import com.acardona.plantatracker.data.model.Plant
import com.acardona.plantatracker.databinding.FragmentPlantMainBinding
import com.acardona.plantatracker.ui.plant.plantmain.recyclerview.PlantRecyclerViewAdapter
import com.acardona.plantatracker.ui.viewmodel.PlantViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [PlantMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlantMainFragment : Fragment() {
    private lateinit var binding: FragmentPlantMainBinding

    private lateinit var adapter: PlantRecyclerViewAdapter

    val viewModel : PlantViewModel by activityViewModels {
        PlantViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlantMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_plantMainFragment_to_newPlantFragment)
        }

    }

    private fun setRecyclerView(view: View) {
        binding.plantsRecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = PlantRecyclerViewAdapter {
            showSelectedPlants(it)
        }

        binding.plantsRecyclerView.adapter = adapter
        displayPlants()

    }

    private fun showSelectedPlants(plant: Plant) {
        viewModel.setSelectedPlant(plant)
        findNavController().navigate(R.id.action_plantMainFragment_to_infoPlantFragment)
    }

    private fun displayPlants() {
        adapter.setData(viewModel.getPlants())
        adapter.notifyDataSetChanged()
    }

}