package com.example.projet_tdm.database.arret

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*

@Entity(tableName = "arrets", primaryKeys = ["num_ar"])
data class Arret (
    @ColumnInfo(name = "num_ar") val numAr: Int,
    @ColumnInfo(name = "chambre_ar") val chambreAR: String,
    @ColumnInfo(name = "date_ar") val dateAr: Date,
    @ColumnInfo(name = "parties_ar") val partiesAr: String,
    @ColumnInfo(name = "principe_ar") val principeAr: String,
    @ColumnInfo(name = "decision_ar") val decisionAr: String,
    @ColumnInfo(name = "decision_oper_ar") val decisionOperAr: String,
    @ColumnInfo(name = "composition_ar") val compositionAr: String,
    @ColumnInfo(name = "reference_ar") val referenceAr: String,
    @ColumnInfo(name = "annee_ref") val anneeRef: Int,
    @ColumnInfo(name = "num_ref") val numRef: Int,
    @ColumnInfo(name = "num_page_ref") val numPageRef: Int,
    @ColumnInfo(name = "favorite") val favorite: Boolean,
)
