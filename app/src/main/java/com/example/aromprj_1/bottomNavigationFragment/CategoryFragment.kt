package com.example.aromprj_1.bottomNavigationFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.aromprj_1.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_category.*
// 네비게이션 - 카테고리
class CategoryFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager()

    }
    fun viewPager() {
        viewPager3.adapter=PagerAdapter(requireActivity())
        viewPager3.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        viewPager3.offscreenPageLimit=2

        // 탭과 뷰페이저 연결
        TabLayoutMediator(tabs,viewPager3){tab,position->
            if (position==0)
                tab.text="장르"
            else tab.text="지역"
        }.attach()
    }
    inner class PagerAdapter: FragmentStateAdapter {
        constructor(activity: FragmentActivity):super(activity)
        override fun getItemCount() = 2

        override fun createFragment(position: Int): Fragment {
            when(position){
                0-> return CategoryFragmentItem1()
                1-> return CategoryFragmentItem2()
                else -> return CategoryFragmentItem1()
            }
        }
    }
}