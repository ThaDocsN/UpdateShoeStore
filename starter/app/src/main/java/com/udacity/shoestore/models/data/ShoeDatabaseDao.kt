package com.udacity.shoestore.models.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShoeDatabaseDao {
    @Insert
    suspend fun insert(shoe: Shoe)
    @Query(value = "SELECT * FROM shoe_table WHERE _id = :key")
    suspend fun get(key:Long):Shoe
    @Query(value = "SELECT * FROM shoe_table ORDER BY _id DESC")
    fun getAllShoes(): LiveData<List<Shoe>>
    @Query(value = "DELETE FROM shoe_table")
    suspend fun clear()
}