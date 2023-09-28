package com.example.assignmentcits

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.viewpager.widget.ViewPager
import android.view.ViewGroup
import com.example.assignmentcits.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {
    private lateinit var bindingFragmentHome: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragmentHome = FragmentHomeBinding.inflate(inflater,container,false)
        val view = bindingFragmentHome.root
        var tab1 = bindingFragmentHome.tabLayout.newTab()
        tab1.text = "FEATURED"
        bindingFragmentHome.tabLayout.addTab(tab1)

        var tab2 = bindingFragmentHome.tabLayout.newTab()
        tab2.text = "PLUS"
        bindingFragmentHome.tabLayout.addTab(tab2)

        val adapter = viewPagerAdapter(childFragmentManager)

        adapter.addFragment(FragmentFratured(),"FEATURE")
        adapter.addFragment(FragmentCricbuzzPlus(),"PLUS")

        bindingFragmentHome.viewPager.adapter = adapter

        bindingFragmentHome.tabLayout.setupWithViewPager(bindingFragmentHome.viewPager)

        return view
    }
}