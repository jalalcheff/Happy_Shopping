package com.example.happyshopping.ui.category

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.happyshopping.R
import com.example.happyshopping.databinding.FragmentCategoryBinding

class CategoryFragment:Fragment() {
    val viewModel : CategoryViewModel by viewModels()
    lateinit var binding:FragmentCategoryBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.fragment_category)
        binding.viewModel=viewModel
    }
}