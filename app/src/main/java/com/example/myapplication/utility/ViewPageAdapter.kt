package com.example.myapplication.utility

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentScreenList =  ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()
//    override fun getItemCount(): Int {
//        return fragmentScreenList.size
//    }

    fun addFragmentTab(fragment:Fragment,title:String){
        fragmentScreenList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentTitleList[position]
    }

//
//    override fun createFragment(position: Int): Fragment {
//        return fragmentScreenList[position]
//    }

    override fun getCount(): Int {
        return fragmentScreenList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentScreenList[position]
    }

}