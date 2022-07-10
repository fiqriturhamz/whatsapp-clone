package com.example.whatsapp.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.adapter.ChatAdapter
import com.example.whatsapp.data.Chat
import com.example.whatsapp.ui.detail.DetailChat
import com.example.whatsapp.utils.ChatDummy

class ChatFragment : Fragment() {

    private lateinit var  rvChat:RecyclerView
    private val list = ArrayList<Chat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvChat = view.findViewById(R.id.rvChat)
        rvChat.setHasFixedSize(true)

        showRecycler()
        list.addAll(showChat())
        super.onViewCreated(view, savedInstanceState)


    }

    private fun showChat() : ArrayList<Chat>{

        val nameUser = ChatDummy.idolName
        val img = ChatDummy.imgUser
        val date = ChatDummy.dateChat
        val detailChat = ChatDummy.idolMessage
        val pinned = ChatDummy.isPinned
        val listChat = ArrayList<Chat>()
        for(i in nameUser.indices){
            val chat = Chat(img[i],nameUser[i],date[i],detailChat[i],pinned[i])
            listChat.add(chat)
        }

        return listChat

    }

    private fun showRecycler(){
        rvChat.layoutManager = LinearLayoutManager(activity)
        val chatAdapter = ChatAdapter(list)
        rvChat.adapter = chatAdapter

        chatAdapter.setOnItemClickCallback(object : ChatAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Chat) {
                val intent = Intent(activity,DetailChat::class.java)
                startActivity(intent)
            }
        })
    }


}