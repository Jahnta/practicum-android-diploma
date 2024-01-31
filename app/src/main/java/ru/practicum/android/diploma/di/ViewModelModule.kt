package ru.practicum.android.diploma.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.practicum.android.diploma.ui.favourite.viewmodel.FavouriteViewModel
import ru.practicum.android.diploma.ui.details.viewmodel.VacancyDescriptionViewModel
import ru.practicum.android.diploma.ui.search.viewmodel.SearchViewModel

val viewModelModule = module {

    viewModel { VacancyDescriptionViewModel(get(), get()) }

    viewModel { SearchViewModel(get()) }
    viewModel {
        SearchViewModel(get())
    }

    viewModel {
        FavouriteViewModel(get())
    }
}
