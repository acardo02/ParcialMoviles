package com.acardona.plantatracker.ui.plant.newplant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.acardona.plantatracker.R
import com.acardona.plantatracker.databinding.FragmentNewPlantBinding
import com.acardona.plantatracker.ui.viewmodel.PlantViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [NewPlantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewPlantFragment : Fragment() {

    private lateinit var binding: FragmentNewPlantBinding

    val viewModel : PlantViewModel by activityViewModels {
        PlantViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPlantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        setObserver()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

    private fun setObserver() {
        viewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(PlantViewModel.PLANT_CREATED) -> {
                    viewModel.clearData()
                    viewModel.clearStatus()

                    findNavController().popBackStack()
                }
                status.equals(PlantViewModel.WRONG_DATA) -> {
                    viewModel.clearStatus()
                }
            }
        }
    }

}