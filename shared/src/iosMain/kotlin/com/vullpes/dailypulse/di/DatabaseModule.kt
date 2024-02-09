package com.vullpes.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.vullpes.dailypulse.db.DailyPulseDatabase
import com.vullpes.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module{
    single<SqlDriver>{
        DatabaseDriverFactory().createDriver()
    }

    single<DailyPulseDatabase>{
        DailyPulseDatabase(get())
    }
}