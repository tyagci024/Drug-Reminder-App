package com.example.apptez.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apptez.R
import com.example.apptez.view.model.Drug
import com.example.apptez.view.model.Person
import com.example.apptez.view.model.Pharmacy

class PharmacyAdapter (val pharmacyList:ArrayList<Pharmacy>) : RecyclerView.Adapter<PharmacyAdapter.PharmacyHolder>(){
    class PharmacyHolder (var view: View):RecyclerView.ViewHolder(view){
        val pName = view.findViewById<TextView>(R.id.dNameP)
        val pAdres = view.findViewById<TextView>(R.id.talimatP)
        val number = view.findViewById<TextView>(R.id.number)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.r_row2,parent,false)
        return PharmacyHolder(view)
    }

    override fun onBindViewHolder(holder: PharmacyHolder, position: Int) {
        holder.pName.text=pharmacyList[position].countryCapital
        holder.pAdres.text=pharmacyList[position].countryName
        holder.number.text=pharmacyList[position].number

    }

    override fun getItemCount(): Int {
        return pharmacyList.size
    }
    fun updateData(newPharmacyList : List<Pharmacy>){
        pharmacyList.clear()
        pharmacyList.addAll(newPharmacyList)
        notifyDataSetChanged()
    }
}