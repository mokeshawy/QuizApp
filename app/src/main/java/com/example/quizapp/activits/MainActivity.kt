package com.example.quizapp.activits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        val navHostFragment : NavHostFragment   = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController   : NavController     = navHostFragment.navController

        var appBarConfiguration = AppBarConfiguration(setOf())

        setupActionBarWithNavController(navController , appBarConfiguration)

        // Operation show and hide action bar for fragment page
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){

                R.id.splashFragment             -> supportActionBar!!.hide()
                R.id.mainFragment               -> supportActionBar!!.hide()
                R.id.quizQuestionsFragment      -> supportActionBar!!.hide()
                R.id.resultFragment             -> supportActionBar!!.hide()
                else -> supportActionBar!!.show()

            }
        }
    }
}