package ru.practicum.android.diploma.data.impl.search

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.practicum.android.diploma.R
import ru.practicum.android.diploma.data.converters.VacanciesConverter
import ru.practicum.android.diploma.data.converters.VacanciesDescriptionConverter
import ru.practicum.android.diploma.data.dto.ResponseCode
import ru.practicum.android.diploma.data.dto.VacancyDescriptionRequest
import ru.practicum.android.diploma.data.dto.VacancyDescriptionResponse
import ru.practicum.android.diploma.data.network.NetworkClient
import ru.practicum.android.diploma.data.request.SearchRequest
import ru.practicum.android.diploma.data.response.VacanciesResponse
import ru.practicum.android.diploma.domain.api.search.SearchRepository
import ru.practicum.android.diploma.domain.models.Vacancies
import ru.practicum.android.diploma.domain.models.VacancyDescription
import ru.practicum.android.diploma.util.Resource

class SearchRepositoryImpl(
    private val networkClient: NetworkClient,
    private val vacanciesConverter: VacanciesConverter,
    private val vacanciesDescriptionConverter: VacanciesDescriptionConverter,
    context: Context
) : SearchRepository {
    private val badConnection by lazy {
        context.getString(R.string.bad_connection)
    }
    private val serverError by lazy {
        context.getString(R.string.server_error)
    }

    override fun getVacancyDescription(vacancyId: String): Flow<Resource<VacancyDescription>> = flow {
        val response = networkClient.doRequest(VacancyDescriptionRequest(vacancyId))
        when (response.resultCode) {
            ResponseCode.NETWORK_FAILED -> {
                emit(Resource.Error(message = badConnection))
            }

            ResponseCode.SUCCESS -> {
                with(response as VacancyDescriptionResponse) {
                    val data = vacanciesDescriptionConverter.convertVacancyDescription(response)
                    emit(Resource.Success(data))
                }
            }

            else -> emit(Resource.Error(message = serverError))
        }
    }

    override fun searchVacancies(options: HashMap<String, String>): Flow<Resource<Vacancies>> = flow {
        val response = networkClient.doRequest(SearchRequest(options))
        when (response.resultCode) {
            ResponseCode.NETWORK_FAILED -> {
                emit(Resource.Error(badConnection))
            }

            ResponseCode.SUCCESS -> {
                with(response as VacanciesResponse) {
                    val data = vacanciesConverter.convert(response)
                    emit(Resource.Success(data))
                }
            }

            else -> emit(Resource.Error(serverError))
        }
    }

}
