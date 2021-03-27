package cl.eme.pruebasencetd.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//POJOs

@Entity (tableName = "cakes")

data class Cakes (
        @PrimaryKey val id: Int,
        val title: String,
        val previewDescription: String,
        val size: String,
        val price: String,
        val image: String,
        )
data class CakeDetail (
        @PrimaryKey val id: String,
        val title: String,
        val previewDescription: String,
        val detailDescription: String,
        val image: String,
        val shape: String,
        val size: String,
        val price: String,
        val lastPrice: String,
        val delivery: String,
        )