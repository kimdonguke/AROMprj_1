package com.example.aromprj_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewPager.adapter=PagerAdapter(this)
        viewPager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.offscreenPageLimit=3
        viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                Toast.makeText(applicationContext,"${position}번 페이지 선택",Toast.LENGTH_SHORT).show()
            }
        })


    }
    inner class PagerAdapter:FragmentStateAdapter{
        constructor(activity: FragmentActivity):super(activity)
        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
            when(position){
                0->{
                    return Fragment1()
                }
                1->{
                    return Fragment2()
                }
                2->{
                    return Fragment3()
                }
                else -> return Fragment1()

            }
        }
    }
}