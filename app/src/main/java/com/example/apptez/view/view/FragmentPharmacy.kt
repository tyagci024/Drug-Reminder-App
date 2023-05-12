package com.example.apptez.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptez.R
import com.example.apptez.databinding.FragmentPharmacyBinding
import com.example.apptez.view.adapter.PharmacyAdapter
import com.example.apptez.view.viewModel.PharmacyViewModel

class FragmentPharmacy : Fragment() {
    private val pharmacyViewModel: PharmacyViewModel by viewModels()
    private val pharmacyAdapter=PharmacyAdapter(arrayListOf())
    private var fragmentPharmacyBinding:FragmentPharmacyBinding?=null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pharmacy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPharmacyBinding.bind(view)
        fragmentPharmacyBinding = binding
        pharmacyViewModel.getDataFromApi()
        binding.rcyclrWP.layoutManager=LinearLayoutManager(context)
        binding.rcyclrWP.adapter=pharmacyAdapter
        observeData()
    }

    fun observeData(){
        pharmacyViewModel.pharmacyValue.observe(viewLifecycleOwner, Observer {
            it?.let {
                pharmacyAdapter.updateData(it)
            }

        })
    }




}