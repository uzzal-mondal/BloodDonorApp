package com.blood.blooddonorapp


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.blood.blooddonorapp.databinding.ActivityMainBinding
import com.blood.blooddonorapp.databinding.DialogUserDetailsBinding
import com.blood.blooddonorapp.db.BloodUserDataBase
import com.blood.blooddonorapp.db.Data
import com.blood.blooddonorapp.fragment.homefm.HomeFragment
import com.google.android.material.navigation.NavigationView
import java.util.*


class MainActivity : AppCompatActivity() {
    // private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var userDetailsBinding: DialogUserDetailsBinding
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
        userDetailsBinding = DialogUserDetailsBinding.inflate(layoutInflater)
        dialog.setContentView(userDetailsBinding.root)


        userDetailsBinding.btnClose.setOnClickListener {
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
            showBloodGp()

            userDetailsBinding.textDate.setOnClickListener {
                showDateDialog()
                userDetailsBinding.textDate.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.black
                    )
                )
            }

            userDetailsBinding.textTime.setOnClickListener {
                showTimeDialog()
                userDetailsBinding.textTime.setTextColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.black
                    )
                )
            }

            userDetailsBinding.btnSubmit.setOnClickListener {
                val donorName = userDetailsBinding.etDonorName.text.toString()
                val patientPb = userDetailsBinding.etPatientPb.text.toString()
                val bloodGp = userDetailsBinding.autoTextBloodGroup.text.toString()
                val bloodBagAmount = userDetailsBinding.etBloodBag.text.toString()
                val date = userDetailsBinding.textDate.text.toString()
                val time = userDetailsBinding.textTime.text.toString()
                val hospitalPlace = userDetailsBinding.etHospital.text.toString()
                val contact = userDetailsBinding.etContact.text.toString()



                when {
                    patientPb.isEmpty() -> {
                        userDetailsBinding.etPatientPb.error = "patient problem required"
                    }
                    bloodGp.isEmpty() -> {
                        userDetailsBinding.autoTextBloodGroup.error = "blood group required"
                    }
                    bloodBagAmount.isEmpty() -> {
                        userDetailsBinding.etBloodBag.error = "blood bag  required"
                    }
                    date.isEmpty() -> {
                        userDetailsBinding.textDate.error = "date  required"
                    }
                    time.isEmpty() -> {
                        userDetailsBinding.textTime.error = "time  required"
                    }
                    hospitalPlace.isEmpty() -> {
                        userDetailsBinding.etHospital.error = "hospital name required"
                    }
                    donorName.isEmpty() -> {
                        userDetailsBinding.etDonorName.error = "donor name required"
                    }
                    contact.isEmpty() -> {
                        userDetailsBinding.etContact.error = "contact  required"
                    }
                    else -> {
                        /**
                         * create a data list object from room entities.
                         */
                        val data = Data(
                            donorName,
                            patientPb,
                            bloodGp,
                            bloodBagAmount,
                            date,
                            time,
                            hospitalPlace,
                            contact
                        )
                        val insertedRowId =
                            BloodUserDataBase.getInstance(this!!).getDao().insertNewUserData(data)
                        if (insertedRowId > 0) {
                            Toast.makeText(this, "inserted success", Toast.LENGTH_SHORT).show()
                            val homeFragment = HomeFragment()
                            val fragment: Fragment? =
                                supportFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
                            if (fragment !is HomeFragment) {
                                supportFragmentManager.beginTransaction()
                                    .add(
                                        R.id.container_host_fragment, homeFragment,
                                        HomeFragment::class.java.simpleName
                                    )
                                    .commit()

                            }
                        } else {
                            Toast.makeText(this, "inserted unsuccessfully", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
            dialog.show()
        }
    }

    private fun showBloodGp() {
        var blGp = arrayOf("A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-")
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, blGp)
        userDetailsBinding.autoTextBloodGroup.threshold = 0
        userDetailsBinding.autoTextBloodGroup.setAdapter(adapter)
        userDetailsBinding.autoTextBloodGroup.setOnFocusChangeListener { view, b ->
            if (b) userDetailsBinding.autoTextBloodGroup.showDropDown()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showDateDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                userDetailsBinding.textDate.text = "$dayOfMonth/ $monthOfYear/ $year"
            },
            year,
            month,
            day
        )

        dpd.show()
    }

    @SuppressLint("SetTextI18n")
    private fun showTimeDialog() {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)
        val tpd =
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener(function = { _, h, m ->
                userDetailsBinding.textTime.text = "$h : $m  "
            }), hour, minute, false)
        tpd.show()
    }
}






