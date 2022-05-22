package com.example.aromprj_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.aromprj_1.bottomNavigationFragment.CategoryFragment
import com.example.aromprj_1.bottomNavigationFragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = HomeFragment()
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
        var fragment:Fragment = HomeFragment()
        when(index){
            1->{
                fragment= HomeFragment()
            }
            2->{
                fragment= CategoryFragment()
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
}