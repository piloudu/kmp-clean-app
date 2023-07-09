package android.template.datasources

import android.template.api.apimodels.rickandmorty.RickAndMortyApiModel
import android.template.api.apimodels.rickandmorty.RickAndMortyCharacterApiModel
import android.template.api.retrofit.NetworkClient
import android.template.api.service.RickAndMortyService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class RickAndMortyDataSourceImpl(
    networkClient: NetworkClient,
) : RickAndMortyDataSource {

    private val service = networkClient.retrofit.create(RickAndMortyService::class.java)

    override fun getRickAndMortyCharacter(): Flow<RickAndMortyApiModel> {
        return flow {
            emit(service.getRickAndMortyCharacter())
        }
    }

    override fun getRickAndMortyCharacterFor(characterId: Int): Flow<RickAndMortyCharacterApiModel> {
        return flow {
            emit(service.getRickAndMortyCharacterFor(characterId))
        }
    }
}
