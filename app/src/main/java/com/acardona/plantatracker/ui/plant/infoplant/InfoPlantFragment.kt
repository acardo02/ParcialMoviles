package com.acardona.plantatracker.ui.plant.infoplant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.acardona.plantatracker.databinding.FragmentInfoPlantBinding
import com.acardona.plantatracker.ui.viewmodel.PlantViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [InfoPlantFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoPlantFragment : Fragment() {

    private lateinit var binding: FragmentInfoPlantBinding

    val viewModel : PlantViewModel by activityViewModels {
        PlantViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoPlantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = viewModel
    }

}