package com.example.aromprj_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = MainFragment()
        onFragmentSelected(1)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1->{
                    onFragmentSelected(1)
                }
                R.id.item2->{
                    onFragmentSelected(2)
                }
                R.id.item3->{
                    onFragmentSelected(3)
                }
            }
            return@setOnNavigationItemSelectedListener true
        }





    }
    fun onFragmentSelected(index:Int){
        var fragment:Fragment = Fragment()
        when(index){
            1->{
                fragment=MainFragment()
            }
            2->{
                fragment=CategoryFragment()
            }
            3->{
                fragment=Fragment3()
            }
            4->{

            }
            5->{

            }
        }
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit()
    }
    fun viewPager(){
        viewPager1.adapter=PagerAdapter(this)
        viewPager1.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        viewPager1.offscreenPageLimit=3
        indicator1.setViewPager(viewPager1)
        indicator1.createIndicators(3,0)

        viewPager1.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicator1.animatePageSelected(position)

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