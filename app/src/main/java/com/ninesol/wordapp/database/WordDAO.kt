package com.ninesol.wordapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ninesol.wordapp.model.Word

@Dao
interface WordDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word)

    @Query("SELECT * FROM words")
    fun getAllWords(): LiveData<List<Word>>
}