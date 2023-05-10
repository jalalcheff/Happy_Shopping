package com.example.happyshopping.ui.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category,container,false)
        binding.viewModel=viewModel
        viewModel.category.observe(requireActivity()){
            Log.i("jalalCheff",it.toString())
        }
        return binding.root
    }
}