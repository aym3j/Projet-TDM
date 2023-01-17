package com.example.projet_tdm

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projet_tdm.database.arret.Arret
import com.example.projet_tdm.databinding.ActivityMainBinding

val arrets = mutableListOf<Arret>(
    Arret(1, "الغرفة الإدارية", "21-11-1987", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "الغرفة المدنية", "25-02-1989", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "الغرفة التجارية و البحرية", "21-11-1987", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "مجلس الدولة", "25-02-1989", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "الغرفة الجنائية", "21-11-1987", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "غرفة الجنح و المخالفات", "25-02-1989", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "غرفة الأحوال الشخصية", "21-11-1987", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "الغرفة الإدارية", "21-11-1987", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "الغرفة المدنية", "25-02-1989", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "الغرفة التجارية و البحرية", "21-11-1987", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "مجلس الدولة", "25-02-1989", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "الغرفة الجنائية", "21-11-1987", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "غرفة الجنح و المخالفات", "25-02-1989", "", "", "", "", "", "", 0 ,0, 0),
    Arret(1, "غرفة الأحوال الشخصية", "21-11-1987", "", "", "", "", "", "", 0 ,0, 0),
)
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}