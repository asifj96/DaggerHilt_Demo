package com.ninesol.wordapp.di

import com.ninesol.wordapp.repo.WordRepository
import com.ninesol.wordapp.repo.WordRepositoryImpl
import com.ninesol.wordapp.database.WordDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object WordsModule {

    @Provides
    fun provideWordRepository(wordDAO: WordDAO) : WordRepository {

        return WordRepositoryImpl(wordDAO)
    }
}