package com.blood.blooddonorapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.blood.blooddonorapp.databinding.ActivityMainBinding


import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    // private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarInclude.myToolbar)
        showBottomNav()
        showDrawerNav()
        showAddData()
    }

    private fun showBottomNav() {
        binding.bottomNavView.background = null
        //bottomNav.menu.getItem(3).isEnabled = false
        navController = findNavController(R.id.container_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home_fragment, R.id.profile_fragment,
                R.id.bookmark_fragment, R.id.notification_fragment
            )
        )
        binding.bottomNavView.setupWithNavController(navController)
    }

    private fun showDrawerNav() {
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navigationView
        val navController = findNavController(R.id.container_host_fragment)
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
        val navController = findNavController(R.id.container_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun showAddData() {
        binding.fabBtn.setOnClickListener {
            showUserDetailsDialog()
        }
    }

    private fun showUserDetailsDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_user_details)
        val close = dialog.findViewById<ImageView>(R.id.btn_close)
        val submitBtn = dialog.findViewById<Button>(R.id.btn_submit)

        val etPatient = dialog.findViewById<TextInputEditText>(R.id.et_patient)
        val bloodGroup = dialog.findViewById<AutoCompleteTextView>(R.id.auto_text_blood_group)
        val etBloodBag = dialog.findViewById<TextInputEditText>(R.id.et_blood_bag)
        val etHospital = dialog.findViewById<TextInputEditText>(R.id.et_hospital)




        close?.setOnClickListener {
            if (dialog.isShowing) {
                dialog.dismiss()
            }
        }
        val window: Window = dialog.window!!
        window.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //
        if (!dialog.isShowing) {
            submitBtn?.setOnClickListener {


            }
            dialog.show()
        }

    }

    private fun validateSignIn() {

    }
}




