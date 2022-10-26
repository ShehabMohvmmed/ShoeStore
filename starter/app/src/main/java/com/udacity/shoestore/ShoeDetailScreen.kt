package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeDetailScreenBinding
import com.udacity.shoestore.databinding.FragmentShoeListScreenBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailScreen : Fragment() {
    lateinit var binding: FragmentShoeDetailScreenBinding

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val shoe = Shoe()

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail_screen,container,false)
        binding.shoeModel = shoe

        binding.cancelBtn.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.saveBtn.setOnClickListener {
            sharedViewModel.addShoe(shoe)
            findNavController().navigateUp()
        }

        return binding.root
    }

}