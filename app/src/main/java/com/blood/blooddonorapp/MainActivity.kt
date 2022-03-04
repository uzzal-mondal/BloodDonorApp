package com.blood.blooddonorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.blood.blooddonorapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    /**
     * bottom nav
     */
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showBottomNav()
        showNavigationView()
    }

    private fun showBottomNav() {
        binding.bottomNavView.background = null
        //bottomNav.menu.getItem(3).isEnabled = false
        navController = findNavController(R.id.fragment_container_view)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home_fragment, R.id.profile_fragment,
                R.id.bookmark_fragment, R.id.notification_fragment
            )
        )
        binding.bottomNavView.setupWithNavController(navController)

    }

    private fun showNavigationView() {



        /*val navController = findNavController(R.id.fragment_container_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.home_fragment, R.id.profile_fragment, R.id.bookmark_fragment),
            binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigationView.setupWithNavController(navController)*/

    }
}