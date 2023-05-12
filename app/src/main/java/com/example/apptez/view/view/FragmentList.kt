package com.example.apptez.view.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptez.R
import com.example.apptez.databinding.FragmentListBinding
import com.example.apptez.view.adapter.RwAdapter
import com.example.apptez.view.viewModel.DrugViewModel


class FragmentList : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val drugViewModel:DrugViewModel by viewModels()
    private lateinit var rwAdapter: RwAdapter
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.rcyclrW.layoutManager=LinearLayoutManager(context)
        rwAdapter= RwAdapter()
        binding.rcyclrW.adapter=rwAdapter
        drugViewModel.readAllData.observe(viewLifecycleOwner,{
            it?.let {
                rwAdapter.updateData(it)
                if(it.size==0){
                    Toast.makeText(context,"liste boş", Toast.LENGTH_LONG).show()
                }

            }
        })
        setHasOptionsMenu(true)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentList_to_fragmentNewTreatment)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.list_bar,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.deleteall){
            drugViewModel.deleteAll()
        }
        return super.onOptionsItemSelected(item)
    }
}