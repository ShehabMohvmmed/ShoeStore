package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentShoeListScreenBinding
import com.udacity.shoestore.databinding.ShoeItemLinearlayoutBinding
import com.udacity.shoestore.models.Shoe


class ShoeListScreen : Fragment() {
    lateinit var binding: FragmentShoeListScreenBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list_screen,container,false)
        binding.floatingActionButton.setOnClickListener {
            val action = ShoeListScreenDirections.actionShoeListToShoeDetailScreen()
            Navigation.findNavController(requireView()).navigate(action)
        }

        sharedViewModel.shoeList.observe(viewLifecycleOwner) { shoesList ->
            shoesList.forEach { shoe ->
                val itemBinding = ShoeItemLinearlayoutBinding.inflate(inflater)
                itemBinding.shoeDetail = shoe
                binding.shoeListScreen.addView(itemBinding.root)
            }
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main,menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.loginScreen) {
            val action = ShoeListScreenDirections.actionShoeListToLoginScreen()
            Navigation.findNavController(requireView()).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }


}
