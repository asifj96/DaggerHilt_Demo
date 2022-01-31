package com.ninesol.wordapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ninesol.wordapp.model.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordsDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDAO

    // at this stage provide database instance using Hilt instead of  using BoilerPlate Code


}