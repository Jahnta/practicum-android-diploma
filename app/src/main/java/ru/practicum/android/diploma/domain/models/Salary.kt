package ru.practicum.android.diploma.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Salary(
    val currency: String?,
    val from: Int?,
    val gross: Boolean?,
    val to: Int?
) : Parcelable
