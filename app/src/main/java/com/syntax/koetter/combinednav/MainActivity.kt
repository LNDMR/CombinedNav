package com.syntax.koetter.combinednav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.syntax.koetter.combinednav.ui.CommunityFragment
import com.syntax.koetter.combinednav.ui.HomeFragment
import com.syntax.koetter.combinednav.ui.PersonalDataFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        // val navController = findNavController(R.id.nav_host_fragment)
        val bottomNav = this.findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.getMenu().findItem(R.id.homeFragment).isChecked = true
        bottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.detailFragment) {
                bottomNav.visibility = View.GONE
            } else {
                bottomNav.visibility = View.VISIBLE
            }
        }
        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> navigateTo(HomeFragment())
                R.id.profilFragment -> navigateTo(PersonalDataFragment())
                R.id.communityFragment -> navigateTo(CommunityFragment())
                else -> {
                    // Toast.makeText(this,"problemchen", Toast.LENGTH_SHORT)
                    //    .show()
                }
            }
            true
        }
    }

    // navigate between fragments via fragmentManager
    private fun navigateTo(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        if(fragment.isAdded())
        {
            return; //or return false/true, based on where you are calling from
        }
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }
}