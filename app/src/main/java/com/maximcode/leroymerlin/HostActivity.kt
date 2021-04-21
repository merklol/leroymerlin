package com.maximcode.leroymerlin

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maximcode.leroymerlin.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity(R.layout.activity_host) {

    private val binding by viewBinding(ActivityHostBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_container) as NavHostFragment

        val navView: BottomNavigationView = binding.navView
        navView.setupWithNavController(navHostFragment.navController)
    }
}