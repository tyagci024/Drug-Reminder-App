package com.example.apptez.view.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.apptez.R
import com.example.apptez.databinding.FragmentAdminBinding
import com.example.apptez.databinding.FragmentTreatmentUpdateBinding
import com.example.apptez.view.viewModel.DrugViewModel
import com.example.apptez.view.viewModel.PersonViewModel


class FragmentAdmin : Fragment() {

    private var _binding: FragmentAdminBinding?=null
    private val binding get() = _binding!!
    private val args by navArgs<FragmentAdminArgs>()
    private val drugViewModel:DrugViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val username = sharedPreferences.getString("username", "default_username")

        //binding.personName.setText(username)





    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAdminBinding.inflate(inflater, container, false)
        val view = binding.root
        val sharedPref = requireActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val name = sharedPref?.getString("key", "İsim").toString()
        val age = sharedPref?.getString("age", "Yaş").toString()
        val adres = sharedPref?.getString("adres", "Adres").toString()
        val blood = sharedPref?.getString("blood", "Kan Grubu").toString()
        val gsm = sharedPref?.getString("gsm", "Cep Numarası").toString()

        println(name)
        binding.personName.text=name
        binding.personAge.text=age
        binding.adres.text=adres
        binding.spinnerBloodGroup.text=blood
        binding.pGSM.text=gsm



        // Inflate the layout for this fragment
        binding.buttonSettings.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentAdmin_to_fragmentPersonalInfo)
        }/*
        binding.adresAdmin.setText(args.currentPerson.adres)
        binding.person.setText(args.currentPerson.name)
        binding.pGSMAdmin.setText(args.currentPerson.pNumber.toString().toInt())
        binding.personAgeAdmin.setText(args.currentPerson.age.toString().toInt())*/
        /*drugViewModel.readAllData.observe(viewLifecycleOwner,{
            it?.let {
                binding.personName.setText(it[it.size-1].name)
                binding.personAge.setText((it[it.size-1].offen*7).toString())



                if(it.size==0){
                    Toast.makeText(context,"liste boş", Toast.LENGTH_LONG).show()
                }

            }
        })*/
        return view
    }


}