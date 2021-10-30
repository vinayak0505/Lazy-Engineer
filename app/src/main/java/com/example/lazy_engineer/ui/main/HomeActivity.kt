package com.example.lazy_engineer.ui.main

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.ui.setupWithNavController
import com.example.lazy_engineer.R
import com.example.lazy_engineer.databinding.ActivityHomeBinding
import com.example.lazy_engineer.util.hide
import com.example.lazy_engineer.util.show

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_lazy_engineer)
        binding.bottomNav.setupWithNavController(navController)

        lifecycleScope.launchWhenResumed {
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.home_fragment,R.id.upload_fragment,R.id.account_fragment -> binding.bottomNav.show()
                    else -> binding.bottomNav.hide()
                }
            }
        }
    }



}