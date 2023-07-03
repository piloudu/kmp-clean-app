package android.template.feature.main.ui

import android.template.domain.repositories.ProductsRepository
import android.template.domain.usecases.AddProductsUseCase
import android.template.domain.usecases.GetProductsUseCase
import android.template.feature.main.ui.products.MainProductsUiState
import android.template.feature.main.ui.products.MainProductsViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainProductsViewModelTest {
    private val repository: ProductsRepository by lazy(::FakeProductsRepository)
    private val getProductsUseCase: GetProductsUseCase = GetProductsUseCase(repository)
    private val addProductsUseCase: AddProductsUseCase = AddProductsUseCase(repository)
    private val viewModel = MainProductsViewModel(getProductsUseCase, addProductsUseCase)

    @Test
    fun `When the ViewModel is created Then its state is Loading`() = runTest {
        assertEquals(viewModel.uiState.first(), MainProductsUiState.Loading)
    }

    @Test
    fun `Given  When  Then `() = runTest {
        assertEquals(viewModel.uiState.first(), MainProductsUiState.Loading)
    }
}
