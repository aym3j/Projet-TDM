package com.example.projet_tdm.database.arret

import androidx.room.Dao
import androidx.room.Query
import java.util.*

@Dao
interface ArretDao {

    @Query("SELECT * FROM arrets")
    fun getAll(): List<Arret>

    @Query("SELECT * FROM arrets WHERE favorite = 1")
    fun getFavorites(): List<Arret>

    @Query("SELECT * FROM arrets WHERE num_ar = :numArret")
    fun getArret(numArret: Int): Arret

    //TODO filter function

    //TODO search function

}