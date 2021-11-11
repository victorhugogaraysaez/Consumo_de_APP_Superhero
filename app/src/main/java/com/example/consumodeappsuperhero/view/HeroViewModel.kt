package com.example.consumodeappsuperhero.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumodeappsuperhero.model.Repo
import com.example.consumodeappsuperhero.model.SuperHero
import kotlinx.coroutines.launch

class HeroViewModel: ViewModel() {
    private val repo = Repo()
    val heroes = repo.heroList

    init {
        viewModelScope.launch {
            repo.getHeroes()
        }
    }

    fun getHero(id: Int): LiveData<SuperHero> {
        return repo.getHeroDetail(id)
    }
}