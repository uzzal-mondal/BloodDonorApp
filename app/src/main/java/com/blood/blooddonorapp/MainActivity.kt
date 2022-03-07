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
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.blood.blooddonorapp.databinding.ActivityMainBinding
import com.blood.blooddonorapp.databinding.DialogUserDetailsBinding
import com.google.android.material.navigation.NavigationView
import java.util.*


class MainActivity : AppCompatActivity() {
    // private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var dUserBinding: DialogUserDetailsBinding
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
        dUserBinding = DialogUserDetailsBinding.inflate(layoutInflater)
        dialog.setContentView(dUserBinding.root)


        dUserBinding.btnClose.setOnClickListener {
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

            dUserBinding.textDate.setOnClickListener {
                showDateDialog()
            }

            dUserBinding.textTime.setOnClickListener {
                showTimeDialog()
            }

            dUserBinding.btnSubmit.setOnClickListener {
                val patient = dUserBinding.etPatient.text.toString()
                val bloodGp = dUserBinding.autoTextBloodGroup.text.toList()
                val bloodBag = dUserBinding.etBloodBag.text.toString()
                val date = dUserBinding.textDate.text.toString()
                val time = dUserBinding.textTime.text.toString()
                val hospital = dUserBinding.etHospital.text.toString()
                val district = dUserBinding.etDistrict.text.toString()
                val contact = dUserBinding.etContact.text.toString()


                when {
                    patient.isEmpty() -> {
                        dUserBinding.etPatient.error = "patient name required"
                    }
                    bloodGp.isEmpty() -> {
                        dUserBinding.autoTextBloodGroup.error = "patient name required"
                    }
                    bloodBag.isEmpty() -> {
                        dUserBinding.etBloodBag.error = "patient name required"
                    }
                    date.isEmpty() -> {
                        dUserBinding.textDate.error = "patient name required"
                    }
                    time.isEmpty() -> {
                        dUserBinding.textTime.error = "patient name required"
                    }
                    hospital.isEmpty() -> {
                        dUserBinding.etHospital.error = "patient name required"
                    }
                    district.isEmpty() -> {
                        dUserBinding.etDistrict.error = "patient name required"
                    }
                    contact.isEmpty() -> {
                        dUserBinding.etContact.error = "patient name required"
                    }
                    else -> {
                        Toast.makeText(this, "success.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            dialog.show()
        }
    }

    private fun showBloodGp() {
        var blGp = arrayOf("A+", "B+", "O+", "AB+", "A-", "B-", "O-", "AB-")
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, blGp)
        dUserBinding.autoTextBloodGroup.threshold = 0
        dUserBinding.autoTextBloodGroup.setAdapter(adapter)
        dUserBinding.autoTextBloodGroup.setOnFocusChangeListener { view, b ->
            if (b) dUserBinding.autoTextBloodGroup.showDropDown()
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
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in textbox
                dUserBinding.textDate.setText("" + dayOfMonth + " " + monthOfYear + ", " + year)
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
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener(function = { view, h, m ->
                dUserBinding.textTime.text = "$h : $m : "
            }), hour, minute, false)
        tpd.show()
    }
}






