package com.example.aromprj_1.Board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.aromprj_1.*
import com.example.aromprj_1.Category.CategoryFragmentItem1
import com.example.aromprj_1.Category.CategoryFragmentItem2
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_board.*

// 게시판
class BoardFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_board, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager()
    }
    fun viewPager() {
        viewPager4.adapter=PagerAdapter(requireActivity())
        viewPager4.orientation= ViewPager2.ORIENTATION_HORIZONTAL
        viewPager4.offscreenPageLimit=4
        // 탭과 뷰페이저 연결
        TabLayoutMediator(Boardtabs,viewPager4){tab,position->
            if (position==0)
                tab.text="테마추천"
            else if (position==1)
                tab.text="일행구함"
            else if (position==2)
                tab.text="시간교환"
            else tab.text="자유질문"
        }.attach()
    }
    inner class PagerAdapter: FragmentStateAdapter {
        constructor(activity: FragmentActivity):super(activity)
        override fun getItemCount() = 4

        override fun createFragment(position: Int): Fragment {
            when(position){
                0-> return BoardFragmentItem1()
                1-> return BoardFragmentItem1()
                else -> return BoardFragmentItem1()
            }
        }
    }
}