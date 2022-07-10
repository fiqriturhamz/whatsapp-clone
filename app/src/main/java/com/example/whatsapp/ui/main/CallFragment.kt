package com.example.whatsapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.adapter.CallAdapter
import com.example.whatsapp.data.Call
import com.example.whatsapp.utils.CallDummy
import com.example.whatsapp.utils.CallDummy.imageCaller


class CallFragment : Fragment() {

    private lateinit var rvCall : RecyclerView
    private  var listCall = ArrayList<Call>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_call, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvCall = view.findViewById(R.id.rvCall)
        rvCall.setHasFixedSize(true)
        showRecycler()

        listCall.addAll(showCall())


        super.onViewCreated(view, savedInstanceState)
    }
    private fun showCall () : ArrayList<Call>{
        val caller = CallDummy.caller
        val imgCaller = CallDummy.imageCaller
        val callDate = CallDummy.callDate

        val callData =ArrayList<Call>()

           if (caller.indices == imgCaller.indices ) {

               for(i in caller.indices){
                   val call = Call(imgCaller[i],caller[i],callDate[i])
                   callData.add(call)

               }

           }

        return callData
    }

    private fun showRecycler (){
        rvCall.layoutManager = LinearLayoutManager(activity)
        val callAdapter = CallAdapter(listCall)

        rvCall.adapter = callAdapter

    }
}