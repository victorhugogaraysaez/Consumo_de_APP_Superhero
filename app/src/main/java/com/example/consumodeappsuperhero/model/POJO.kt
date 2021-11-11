package com.example.consumodeappsuperhero.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="superhero_table")
data class SuperHero(
    @PrimaryKey
    val id:Int,
    val name:String,
    val slug:String,
    @Embedded(prefix = "pwr_")
    val powerstats: PowerStats,
    @Embedded(prefix = "app_")
    val appearance: Appearance,
    @Embedded(prefix = "bio_")
    val biography: Biography,
    @Embedded(prefix = "wrk_")
    val work: Work,
    @Embedded(prefix = "con_")
    val connections: Connection,
    @Embedded(prefix = "img_")
    val images: Images
)

data class PowerStats(
    val intelligence: Int,
    val strength: Int,
    val speed: Int,
    val durability: Int,
    val power: Int,
    val combat: Int
)

data class Appearance (
    val gender: String,
    val race: String?,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String?,
    val alignment: String
)

data class Work(
    val occupation: String,
    val base: String
)

data class Connection(
    val groupAffiliation: String,
    val relatives: String
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)