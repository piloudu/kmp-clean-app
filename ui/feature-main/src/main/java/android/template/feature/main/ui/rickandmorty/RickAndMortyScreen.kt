package android.template.feature.main.ui.rickandmorty

import android.template.core.ui.result.UiState
import android.template.core.ui.utils.capitalize
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun RickAndMortyScreen(
    modifier: Modifier = Modifier,
    viewModel: RickAndMortyViewModel = koinViewModel(),
) {
    val uiState: UiState<RickAndMortyUiModel> by viewModel.rickAndMortyUiState.collectAsStateWithLifecycle()
    when (uiState) {
        is UiState.Error -> TODO()
        UiState.Loading -> TODO()
        is UiState.Success -> {
            RickAndMortyScreenInternal(
                modifier = modifier,
                stateProvider = (uiState as UiState.Success)::data,
            )
        }
    }
}

@Composable
private fun RickAndMortyScreenInternal(
    modifier: Modifier = Modifier,
    stateProvider: () -> RickAndMortyUiModel,
) {
    RickAndMortyCard(
        imageUrlsProvider = { listOf(stateProvider().imageUrl) },
        descriptionHeaderProvider = stateProvider()::name,
    ) {
        RickAndMortyDescriptionContent(
            modifier = modifier,
            characterStatusProvider = stateProvider()::status,
            speciesProvider = stateProvider()::species,
            genderProvider = stateProvider()::gender,
            planetProvider = stateProvider()::planet,
        )
    }
}

@Composable
fun RickAndMortyDescriptionContent(
    modifier: Modifier = Modifier,
    characterStatusProvider: () -> String,
    speciesProvider: () -> String,
    genderProvider: () -> String,
    planetProvider: () -> String,
) {
    Column(modifier = modifier) {
        Text(text = "Status: ${characterStatusProvider().lowercase()}")
        Text(text = "Species: ${speciesProvider().capitalize()}")
        Text(text = "Character gender: ${genderProvider().capitalize()}")
        Text(text = "Original from planet: ${planetProvider().capitalize()}")
    }
}