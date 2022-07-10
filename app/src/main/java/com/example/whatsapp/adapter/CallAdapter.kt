package com.example.whatsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.whatsapp.R
import com.example.whatsapp.data.Call
import com.example.whatsapp.utils.CallDummy.imageCaller

class CallAdapter(private val caller : ArrayList<Call>): RecyclerView.Adapter<CallAdapter.CallViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallAdapter.CallViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_call,parent,false)
        return CallViewHolder(view)
    }

    override fun onBindViewHolder(holder: CallAdapter.CallViewHolder, position: Int) {
        val (imageCaller,caller,callDate) = caller[position]
        holder.caller.text=caller
        holder.imageCaller.setImageResource(imageCaller)
        holder.callDate.text =callDate
        for (i in caller ){
            holder.arrow.setImageResource(R.drawable.ic_baseline_arrow_outward_24)
            holder.btnCall.setImageResource(R.drawable.ic_baseline_call_24)
        }



    }

    override fun getItemCount(): Int  = caller.size
    inner class CallViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageCaller= itemView.findViewById<ImageView>(R.id.imageCaller)
         val caller = itemView.findViewById<TextView>(R.id.caller)
        val callDate = itemView.findViewById<TextView>(R.id.callDate)
        val arrow = itemView.findViewById<ImageView>(R.id.arrow)
        val btnCall = itemView.findViewById<ImageView>(R.id.buttonCall)
    }
}