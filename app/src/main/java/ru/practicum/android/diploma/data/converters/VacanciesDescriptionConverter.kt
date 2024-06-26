package ru.practicum.android.diploma.data.converters

import ru.practicum.android.diploma.data.dto.AddressResponse
import ru.practicum.android.diploma.data.dto.AreaResponse
import ru.practicum.android.diploma.data.dto.ContactsResponse
import ru.practicum.android.diploma.data.dto.EmployerResponse
import ru.practicum.android.diploma.data.dto.EmploymentResponse
import ru.practicum.android.diploma.data.dto.ExperienceResponse
import ru.practicum.android.diploma.data.dto.KeySkillResponse
import ru.practicum.android.diploma.data.dto.LogoUrlsResponse
import ru.practicum.android.diploma.data.dto.PhoneResponse
import ru.practicum.android.diploma.data.dto.SalaryResponse
import ru.practicum.android.diploma.data.dto.ScheduleResponse
import ru.practicum.android.diploma.data.dto.VacancyDescriptionResponse
import ru.practicum.android.diploma.domain.models.Address
import ru.practicum.android.diploma.domain.models.Area
import ru.practicum.android.diploma.domain.models.Contacts
import ru.practicum.android.diploma.domain.models.Employer
import ru.practicum.android.diploma.domain.models.Employment
import ru.practicum.android.diploma.domain.models.Experience
import ru.practicum.android.diploma.domain.models.KeySkill
import ru.practicum.android.diploma.domain.models.LogoUrls
import ru.practicum.android.diploma.domain.models.Phone
import ru.practicum.android.diploma.domain.models.Salary
import ru.practicum.android.diploma.domain.models.Schedule
import ru.practicum.android.diploma.domain.models.VacancyDescription

class VacanciesDescriptionConverter {

    fun convertVacancyDescription(response: VacancyDescriptionResponse): VacancyDescription {
        return VacancyDescription(
            id = response.id,
            name = response.name,
            salary = convertSalaryResponse(response.salary),
            employer = convertEmployerResponse(response.employer),
            area = convertAreaResponse(response.area),
            url = response.url,
            address = convertAddressResponse(response.address),
            experience = convertExperienceResponse(response.experience),
            employment = convertEmploymentResponse(response.employment),
            schedule = convertScheduleResponse(response.schedule),
            keySkills = response.keySkills.map { convertKeySkillResponse(it) },
            contacts = convertContactsResponse(response.contacts),
            description = response.description
        )
    }

    fun convertSalaryResponse(response: SalaryResponse?): Salary? {
        return if (response != null) {
            Salary(
                currency = response.currency,
                from = response.from,
                gross = response.gross,
                to = response.to
            )
        } else {
            null
        }
    }

    fun convertEmployerResponse(response: EmployerResponse?): Employer? {
        return if (response != null) {
            Employer(
                alternateUrl = response.alternateUrl,
                id = response.id,
                logoUrls = convertLogoUrlsResponse(response.logoUrls),
                name = response.name,
                url = response.url
            )
        } else {
            null
        }
    }

    fun convertLogoUrlsResponse(response: LogoUrlsResponse?): LogoUrls? {
        return if (response != null) {
            LogoUrls(
                original = response.original
            )
        } else {
            null
        }
    }

    fun convertAreaResponse(response: AreaResponse): Area {
        return Area(
            id = response.id,
            name = response.name,
            url = response.url
        )
    }

    fun convertAddressResponse(response: AddressResponse?): Address? {
        return if (response != null) {
            Address(
                building = response.building,
                city = response.city,
                description = response.description,
                lat = response.lat,
                lng = response.lng,
                street = response.street
            )
        } else {
            null
        }
    }

    fun convertExperienceResponse(response: ExperienceResponse?): Experience? {
        return if (response != null) {
            Experience(
                id = response.id,
                name = response.name
            )
        } else {
            null
        }
    }

    fun convertEmploymentResponse(response: EmploymentResponse?): Employment? {
        return if (response != null) {
            Employment(
                id = response.id,
                name = response.name
            )
        } else {
            null
        }
    }

    fun convertScheduleResponse(response: ScheduleResponse?): Schedule? {
        return if (response != null) {
            Schedule(
                id = response.id,
                name = response.name
            )
        } else {
            null
        }
    }

    fun convertKeySkillResponse(response: KeySkillResponse): KeySkill {
        return KeySkill(
            name = response.name
        )
    }

    fun convertContactsResponse(response: ContactsResponse?): Contacts? {
        return if (response != null) {
            Contacts(
                email = response.email,
                name = response.name,
                phones = response.phones?.map { convertPhoneResponse(it) }
            )
        } else {
            null
        }
    }

    fun convertPhoneResponse(response: PhoneResponse): Phone {
        return Phone(
            city = response.city,
            comment = response.comment,
            country = response.country,
            number = response.number
        )
    }
}
