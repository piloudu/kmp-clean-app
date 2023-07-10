package android.template.domain.usecases

import android.template.domain.models.Test1Model
import android.template.domain.repositories.ITest2Repository
import kotlinx.coroutines.flow.Flow

class GetTest2DataUseCase(
    private val test2Repository: ITest2Repository,
) : () -> Flow<Test1Model> {
    override fun invoke(): Flow<Test1Model> {
        return test2Repository.getTest2Data()
    }
}