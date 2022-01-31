package com.ninesol.wordapp.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module //  This is a Hilt annotation to inform hilt that this class is a module.
@InstallIn(SingletonComponent::class) //  For every module we create, we have to tell Hilt in which component we are going to use it like ApplicationComponent, ActivityComponent, FragmentComponent etc.
object RoomModule {

    @Provides
    fun providesWordsDatabase(@ApplicationContext context: Context): WordsDatabase {

        return Room.databaseBuilder(context, WordsDatabase::class.java, "words.db").build()
    }

    @Provides
    fun providesWordsDao(wordsDatabase: WordsDatabase): WordDAO {

        return wordsDatabase.wordDao()
    }
}