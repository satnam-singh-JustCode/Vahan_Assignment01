package com.example.assignmentcits

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

open class viewPagerCardViewAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)  {
    private lateinit var context: Context
    private val titleList = mutableListOf<Fragment>()
    override fun getCount(): Int {
        return 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getItem(position: Int): Fragment {
        return titleList[position]
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view  = LayoutInflater.from(context).inflate(R.layout.card_adapter_vew,null)
        container.addView(view,0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}