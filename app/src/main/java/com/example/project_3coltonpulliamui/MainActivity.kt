package com.example.project_3coltonpulliamui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.project_3coltonpulliamui.databinding.ActivityMainBinding
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val menu = navView.menu

        navView.itemIconTintList = null

        for (i in 0 until menu.size()) {
            val item: MenuItem = menu.getItem(i)
            //this was how I managed to change the color of my button texts
            val title = SpannableString(item.title)
            when (item.itemId) {
                R.id.Cat -> title.setSpan(ForegroundColorSpan(0xFF00E69C.toInt()), 0, title.length, 0)
                R.id.Dog -> title.setSpan(ForegroundColorSpan(0xFF004AE6.toInt()), 0, title.length, 0)
                R.id.Bael -> title.setSpan(ForegroundColorSpan(0xFFE62900.toInt()), 0, title.length, 0)
            }
            item.title = title
        }

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.Cat, R.id.Dog, R.id.Bael))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }
}