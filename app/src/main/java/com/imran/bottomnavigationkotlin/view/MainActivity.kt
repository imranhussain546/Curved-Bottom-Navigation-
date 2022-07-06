package com.imran.bottomnavigationkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.imran.bottomnavigationkotlin.R
import com.imran.bottomnavigationkotlin.databinding.ActivityMainBinding
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val activeIndex = savedInstanceState?.getInt("activeIndex") ?: 1
//        Log.e("indexx", "onCreate: "+activeIndex )

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.dashBoardFragment,
                R.id.notificationFragment,
                R.id.profileFragment,
                R.id.settingFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        val menuItems = arrayOf(
            CbnMenuItem(
                R.drawable.ic_notification, // the icon
                R.drawable.avd_notification, // the AVD that will be shown in FAB
                R.id.notificationFragment // optional if you use Jetpack Navigation
            ),
            CbnMenuItem(
                R.drawable.ic_dashboard,
                R.drawable.avd_dashboard,
                R.id.dashBoardFragment
            ),
            CbnMenuItem(
                R.drawable.ic_home,
                R.drawable.avd_home,
                R.id.homeFragment
            ),
            CbnMenuItem(
                R.drawable.ic_profile,
                R.drawable.avd_profile,
                R.id.profileFragment
            ),
            CbnMenuItem(
                R.drawable.ic_settings,
                R.drawable.avd_settings,
                R.id.settingFragment
            )
        )
        binding.navView.setMenuItems(menuItems, 2)
        binding.navView.setupWithNavController(navController)
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putInt("activeIndex", binding.navView.getSelectedIndex())
//        super.onSaveInstanceState(outState)
//    }

}