package com.ezlohub.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ReportDatabase {
        return Room.databaseBuilder(
            context,
            ReportDatabase::class.java,
            "database_of_reports"
        )
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    fun provideReportDao(reportDatabase: ReportDatabase): ReportDao {
        return  reportDatabase.getReportDao()
    }
}