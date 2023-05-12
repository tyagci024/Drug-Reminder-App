package com.example.apptez.view.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.apptez.R
import com.example.apptez.databinding.FragmentHomeBinding
import com.example.apptez.view.viewModel.PersonViewModel


class FragmentHome : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding get()=_binding!!
    private val personViewModel: PersonViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        val sharedPref = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val name = sharedPref?.getString("key", "İsim").toString()
        binding.userName.text=name

        return view    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.personal.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentPersonalInfo)
        }*/
        binding.drugList.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentList)
        }
        binding.onPharmacy.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentPharmacy)
        }
        binding.onDocDate.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentCheckUpList)
        }



    }

    override fun onDestroy() {
        super.onDestroy()

    }

}