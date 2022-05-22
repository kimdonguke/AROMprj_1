package com.example.aromprj_1.bottomNavigationFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.aromprj_1.BoardFragmentItem1
import com.example.aromprj_1.BoardFragmentItem2
import com.example.aromprj_1.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_board.*
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {
    val tabTitleArray = arrayOf(
        "장르",
        "지역"
    )
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager()
        TabLayoutMediator(tabs, viewPager3) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
    fun viewPager() {
        viewPager3.adapter=PagerAdapter(requireActivity())
        viewPager3.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        viewPager3.offscreenPageLimit=2
    }
    inner class PagerAdapter: FragmentStateAdapter {
        constructor(activity: FragmentActivity):super(activity)
        override fun getItemCount() = 2

        override fun createFragment(position: Int): Fragment {
            when(position){
                0-> return BoardFragmentItem1()
                1-> return BoardFragmentItem2()
                else -> return BoardFragmentItem1()
            }
        }
    }
}