package com.example.apptez.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.apptez.R
import com.example.apptez.view.model.Drug
import com.example.apptez.view.view.FragmentListDirections

class RwAdapter:RecyclerView.Adapter<RwAdapter.MyViewHolder>() {
    private var drugList = emptyList<Drug>()

    class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val txtName =view.findViewById<TextView>(R.id.dName)

        val perofDay=view.findViewById<TextView>(R.id.talimat)
        fun bind(drug: Drug){
            txtName.setText(drug.name)
            perofDay.text="günde " +drug.timesPerDay +"kere"


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.r_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentDrug=drugList.get(position)
        holder.bind(currentDrug)
        holder.itemView.setOnClickListener {
            val action = FragmentListDirections.actionFragmentListToTreatmentUpdate(currentDrug)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return drugList.size
    }
    fun updateData(list : List<Drug>){
        drugList=list
        notifyDataSetChanged()

    }


}