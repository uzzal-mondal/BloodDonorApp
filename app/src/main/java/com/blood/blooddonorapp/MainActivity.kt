package com.blood.blooddonorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.blood.blooddonorapp.databinding.ActivityMainBinding
import androidx.core.view.GravityCompat
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController


class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout

    /**
     * bottom nav
     */
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarInclude.myToolbar)
        showBottomNav()
        //showDrawerNav()

    }

    private fun showBottomNav() {
        binding.bottomNavView.background = null
        //bottomNav.menu.getItem(3).isEnabled = false
        navController = findNavController(R.id.container_host_fm)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home_fragment, R.id.profile_fragment,
                R.id.bookmark_fragment, R.id.notification_fragment
            )
        )
        binding.bottomNavView.setupWithNavController(navController)


        /* */
        /**
         * bottom with  drawer
         * navigation up button
         *//*
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)

        //drawer navigation
        NavigationUI.setupWithNavController(binding.navigationView, navController)*/

    }

    /*override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }*/

    private fun showDrawerNav() {
        binding.toolbarInclude.imageMenu.setOnClickListener {
            Toast.makeText(applicationContext, "Hello Javatpoint", Toast.LENGTH_LONG).show()
            appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.homes_fragment,
                    R.id.profiles_fragment,
                    R.id.bookmarks_fragment,
                    R.id.notifications_fragment
                ), binding.drawerLayout
            )
            setupActionBarWithNavController(navController, appBarConfiguration)

            navController = findNavController(R.id.container_host_fm)
            binding.navigationView.setupWithNavController(navController)


        }


    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.container_host_fm)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}
