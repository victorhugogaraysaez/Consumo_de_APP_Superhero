package com.example.consumodeappsuperhero.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.consumodeappsuperhero.databinding.FragmentHeroDetailBinding
import coil.load

class HeroDetailFragment(id: Int) : Fragment() {

    private val viewModel: HeroViewModel by viewModels()
    private lateinit var binding: FragmentHeroDetailBinding
    private val heroId = id

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHeroDetailBinding.inflate(layoutInflater)

        viewModel.getHero(heroId).observe(viewLifecycleOwner, {
            binding.imgDetail.load(it.images.lg)
            binding.tvNameDetail.text = "Name: ".plus(it.name)
            binding.tvIdDetail.text = "ID: ".plus(it.id.toString())
            binding.tvIntelligence.text = "Intelligence: ".plus(it.powerstats.intelligence.toString())
            binding.tvStrength.text = "Strength: ".plus(it.powerstats.strength.toString())
            binding.tvSpeed.text = "Speed: ".plus(it.powerstats.speed.toString())
            binding.tvDurability.text = "Durability: ".plus(it.powerstats.durability.toString())
            binding.tvPower.text = "Power: ".plus(it.powerstats.power.toString())
            binding.tvCombat.text = "Combat: ".plus(it.powerstats.combat.toString())
        })

        return binding.root
    }

}