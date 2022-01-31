package com.ninesol.wordapp.repo

import androidx.lifecycle.LiveData
import com.ninesol.wordapp.model.Word

interface WordRepository {

    suspend fun insertWords(word: Word)
    fun getAllWords(): LiveData<List<Word>>
}