package com.ninesol.wordapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ninesol.wordapp.model.Word
import com.ninesol.wordapp.repo.WordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor(private val wordsRepository: WordRepository) :
    ViewModel() {
    fun saveWord(text: String) = liveData {

        try {
            wordsRepository.insertWords(Word(0, text))
            emit(true)
        } catch (e: Exception) {
            emit(false)
        }
    }

    fun getAllWords() = wordsRepository.getAllWords()
}