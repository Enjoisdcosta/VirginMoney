package com.example.virginmoney

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.virginmoney.databinding.ActivityMainBinding
import com.example.virginmoney.ui.people.PeopleFragment
import com.example.virginmoney.ui.room.RoomFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(PeopleFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.peopleFragment -> replaceFragment(PeopleFragment())
                R.id.roomFragment -> replaceFragment(RoomFragment())
                else ->{

                }

            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManger = supportFragmentManager
        val fragmentTransaction = fragmentManger.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}
