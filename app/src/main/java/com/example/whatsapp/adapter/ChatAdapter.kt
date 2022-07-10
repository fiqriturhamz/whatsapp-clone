package com.example.whatsapp.adapter

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapp.R
import com.example.whatsapp.data.Chat
import com.example.whatsapp.ui.detail.DetailChat

class ChatAdapter(private val chatList: ArrayList<Chat>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatAdapter.ChatViewHolder, position: Int) {
        val (photo, nameUser, dateChat, detailChat,pinned) = chatList[position]
        holder.imgChat.setImageResource(photo)
        holder.user.text = nameUser
        holder.date.text = dateChat
        holder.detailChat.text = detailChat
        if( pinned != null && pinned == true ){
            holder.isPinned.setImageResource(R.drawable.ic_baseline_push_pin_24)
        }

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context,"SELAMAT",Toast.LENGTH_SHORT).show()


        }
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(chatList[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = chatList.size

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgChat: ImageView = itemView.findViewById(R.id.img_chat)
        val user: TextView = itemView.findViewById(R.id.user)
        val date: TextView = itemView.findViewById(R.id.date)
        val detailChat: TextView = itemView.findViewById(R.id.detail_chat)
        val isPinned : ImageView = itemView.findViewById(R.id.pinned)
    }

    interface OnItemClickCallback{
        fun onItemClicked(data:Chat)
    }


}