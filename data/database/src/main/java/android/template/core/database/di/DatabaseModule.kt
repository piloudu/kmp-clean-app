/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.template.core.database.di

import android.content.Context
import android.template.core.database.AppDatabase
import android.template.core.database.MyModelDao
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module = module {
    factory<MyModelDao> { get<AppDatabase>().myModelDao() }
    factory<AppDatabase> { buildRoomDatabase(androidContext()) }
}

private fun buildRoomDatabase(appContext: Context) = Room.databaseBuilder(
    appContext,
    AppDatabase::class.java,
    "MyModel",
).build()