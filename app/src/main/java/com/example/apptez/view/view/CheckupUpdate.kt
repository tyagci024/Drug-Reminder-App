package com.example.apptez.view.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.apptez.R
import com.example.apptez.databinding.FragmentCheckUpAddBinding
import com.example.apptez.databinding.FragmentCheckupUpdateBinding
import com.example.apptez.databinding.FragmentTreatmentUpdateBinding
import com.example.apptez.view.model.CheckUpDate
import com.example.apptez.view.viewModel.DateViewModel
import java.util.*


class CheckupUpdate : Fragment() {

    private var _binding: FragmentCheckupUpdateBinding?=null
    private val dateViewModel: DateViewModel by viewModels()
    private val binding get() = _binding!!
    private val args by navArgs<CheckupUpdateArgs>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckupUpdateBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.hospitalUpdate.setText(args.currentDate.Hospital)
        binding.doctorUpdate.setText(args.currentDate.Doctor)
        val hour = binding.timeInputUpdate.hour
        val minute = binding.timeInputUpdate.minute
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)
        val time = calendar.timeInMillis
        val endDateCalendar = Calendar.getInstance()
        endDateCalendar.set(
            binding.checkupDateUpdate.year,
            binding.checkupDateUpdate.month,
            binding.checkupDateUpdate.dayOfMonth
        )
        val endDate = endDateCalendar.timeInMillis

        binding.buttonSaveDateUpdate.setOnClickListener {
            val updateDate =CheckUpDate(args.currentDate.id,endDate,binding.doctorUpdate.text.toString(),binding.hospitalUpdate.text.toString(),time)
            dateViewModel.update(updateDate)
            findNavController().navigate(R.id.action_checkupUpdate_to_fragmentCheckUpList)
        }

        setHasOptionsMenu(true)


        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.list_bar,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.deleteall){
            dateViewModel.delete(args.currentDate)
            findNavController().navigate(R.id.action_checkupUpdate_to_fragmentCheckUpList)
        }
        return super.onOptionsItemSelected(item)
    }



}