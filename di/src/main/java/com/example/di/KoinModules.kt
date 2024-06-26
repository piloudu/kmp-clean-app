package com.example.di

import android.template.core.data.di.repositoriesModule
import android.template.core.database.di.databaseModule
import android.template.di.dataSourcesModule
import android.template.di.networkModule
import android.template.domain.di.useCasesModule
import android.template.feature.main.di.featureMainModule
import org.koin.core.module.Module

val koinModules: List<Module> = listOf(
    repositoriesModule,
    featureMainModule,
    databaseModule,
    dataSourcesModule,
    useCasesModule,
    networkModule,
)

val koinTestModules: List<Module> = listOf(
    repositoriesModule,
    featureMainModule,
    databaseModule,
    useCasesModule,
)
