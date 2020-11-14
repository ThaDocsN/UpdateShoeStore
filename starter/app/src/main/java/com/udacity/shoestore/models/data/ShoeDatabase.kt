package com.udacity.shoestore.models.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Shoe::class], version = 1,exportSchema = false)
abstract class ShoeDatabase:RoomDatabase() {
    abstract val shoeDao: ShoeDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: ShoeDatabase? = null

        fun getInstance(context: Context):ShoeDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context,
                        ShoeDatabase::class.java,
                        "shoe_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}