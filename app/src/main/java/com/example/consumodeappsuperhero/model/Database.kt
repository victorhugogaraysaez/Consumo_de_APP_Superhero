package com.example.consumodeappsuperhero.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HeroDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHero(heroList: List<SuperHero>)

    @Query("SELECT * FROM superhero_table")
    fun getHeroes(): LiveData<List<SuperHero>>

    @Query("SELECT * FROM superhero_table WHERE id=:id")
    fun getHeroDetail(id: Int): LiveData<SuperHero>
}

@Database(entities=[SuperHero::class], version=1)
@TypeConverters(Converters::class)
abstract class SuperHeroDB: RoomDatabase() {
    abstract fun heroDao(): HeroDAO
}

class HeroApplication: Application() {
    companion object {
        var heroDatabase: SuperHeroDB? = null
    }

    override fun onCreate(){
        super.onCreate()

        heroDatabase = Room
            .databaseBuilder(this, SuperHeroDB::class.java, "heroes_db")
            .build()
    }
}