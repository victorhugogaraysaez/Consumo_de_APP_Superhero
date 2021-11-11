package com.example.consumodeappsuperhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.consumodeappsuperhero.databinding.ActivityMainBinding
import com.example.consumodeappsuperhero.view.HeroAdapter
import com.example.consumodeappsuperhero.view.HeroListFragment
import com.example.consumodeappsuperhero.view.HeroViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fmtContainer, HeroListFragment())
            .addToBackStack("back")
            .commit()

        setContentView(binding.root)
    }
}