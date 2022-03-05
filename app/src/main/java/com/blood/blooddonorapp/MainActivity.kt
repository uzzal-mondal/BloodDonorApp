package com.blood.blooddonorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.blood.blooddonorapp.databinding.ActivityMainBinding


import com.blood.blooddonorapp.fragment.bookmarkfm.BookmarkFragment
import com.blood.blooddonorapp.fragment.homefm.HomeFragment
import com.blood.blooddonorapp.fragment.profilefm.ProfileFragment
import com.google.android.material.navigation.NavigationView
import kotlin.reflect.KTypeProjection.Companion.STAR


class MainActivity : AppCompatActivity() {


    private lateinit var toggle: ActionBarDrawerToggle
   // private lateinit var fragmentTransaction: FragmentTransaction

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

       // setSupportActionBar(binding.toolbarInclude.myToolbar)
        setSupportActionBar(binding.toolbarInclude.myToolbar)
        showBottomNav()
        showNav()
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

    }

    private fun showNav(){

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navigationView
        val navController = findNavController(R.id.container_host_fm)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home_fragment, R.id.profile_fragment,
                R.id.bookmark_fragment, R.id.notification_fragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.container_host_fm)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }










    /**
     * it's very important don't delete.
     */
    private fun showDrawerNav() {
        /*toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbarInclude.myToolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )*/
        toggle.drawerArrowDrawable.color = getColor(R.color.white)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        //todo: menu set here.
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        binding.navigationView.setNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {
               /* R.id.homes_fragment -> replaceFragment(HomeFragment(), it.title.toString())
                R.id.profiles_fragment -> replaceFragment(ProfileFragment(), it.title.toString())
                R.id.bookmarks_fragment -> replaceFragment(BookmarkFragment(), it.title.toString())
                R.id.test_fragment -> replaceFragment(TestFragment(), it.title.toString())*/

            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
       // fragmentTransaction.replace(R.id.nav_host_fm, fragment)
        fragmentTransaction.commit()
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        setTitle(title)
    }

}




