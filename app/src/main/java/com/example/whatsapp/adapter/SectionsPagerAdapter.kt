package com.example.whatsapp.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.whatsapp.ui.main.*

class SectionsPagerAdapter(activity:AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
       var fragment:Fragment? = null



        when (position){



            0 -> fragment = CameraFragment()
            1 -> fragment = ChatFragment()
            2 -> fragment = StatusFragment()
            3 -> fragment = CallFragment()

        }
        return fragment as Fragment


    }
}