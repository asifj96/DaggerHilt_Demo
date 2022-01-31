package com.ninesol.wordapp.repo

import androidx.lifecycle.LiveData
import com.ninesol.wordapp.database.WordDAO
import com.ninesol.wordapp.model.Word

class WordRepositoryImpl(private val wordDao: WordDAO) : WordRepository {
    override suspend fun insertWords(word: Word) {
        wordDao.insertWord(word)
    }

    override fun getAllWords(): LiveData<List<Word>> {
        return wordDao.getAllWords()
    }
}