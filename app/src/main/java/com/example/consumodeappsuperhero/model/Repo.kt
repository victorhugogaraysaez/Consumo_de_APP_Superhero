package com.example.consumodeappsuperhero.model

import android.util.Log
import androidx.lifecycle.LiveData

class Repo {

    private val heroDao= HeroApplication.heroDatabase!!.heroDao()
    val heroList = heroDao.getHeroes()

    suspend fun getHeroes() {

        val response = RetrofitClient.instance().getHeroes()

        when(response.isSuccessful) {

            true -> {
                response.body()?.let { heroesList ->
                    heroDao.insertHero(heroesList)
                }}

            false -> {
                Log.d("Repo", "Error:: ${response.errorBody()}")
            }
        }
    }

    fun getHeroDetail(id: Int): LiveData<SuperHero> {
        return heroDao.getHeroDetail(id)
    }
}