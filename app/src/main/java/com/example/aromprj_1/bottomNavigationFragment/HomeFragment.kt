package com.example.aromprj_1.bottomNavigationFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.aromprj_1.Fragment1
import com.example.aromprj_1.Fragment2
import com.example.aromprj_1.Fragment3
import com.example.aromprj_1.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager()
    }

    fun viewPager() {
        viewPager1.adapter=PagerAdapter(requireActivity())
        viewPager1.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        viewPager1.offscreenPageLimit=3
        indicator1.setViewPager(viewPager1)
        indicator1.createIndicators(3,0)

        viewPager1.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator1.animatePageSelected(position)
            }
        })
    }
    inner class PagerAdapter: FragmentStateAdapter {
        constructor(activity: FragmentActivity):super(activity)
        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
            when(position){
                0-> return Fragment1()

                1-> return Fragment2()

                2-> return Fragment3()

                else -> return Fragment1()
            }
        }
    }
}