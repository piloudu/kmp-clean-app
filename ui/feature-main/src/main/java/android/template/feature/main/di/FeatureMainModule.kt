package android.template.feature.main.di

import android.template.feature.main.ui.products.MainProductsViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module

val featureMainModule: Module = module {
    viewModelOf(::MainProductsViewModel)
}
