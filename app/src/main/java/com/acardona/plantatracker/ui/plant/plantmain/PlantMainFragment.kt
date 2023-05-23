package com.acardona.plantatracker.ui.plant.plantmain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.acardona.plantatracker.R
import com.acardona.plantatracker.databinding.FragmentPlantMainBinding
import com.acardona.plantatracker.ui.viewmodel.PlantViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [PlantMainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlantMainFragment : Fragment() {
    private lateinit var binding: FragmentPlantMainBinding

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

        binding.floatingActionButton.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_plantMainFragment_to_newPlantFragment)
        }


    }

}