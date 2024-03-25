
# Агрегатор вакансий

![badge-Android](https://img.shields.io/badge/Platform-Android-brightgreen?logo=android&style=plastic)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.7.10-blue.svg?style=plastic&logo=kotlin)](https://kotlinlang.org)

Приложение для поиска вакансий с использованием [HeadHunter API](https://api.hh.ru/openapi/redoc#section/Obshaya-informaciya).<br>
Приложение позволяет осуществлять поиск вакансий с фильтрацией результатов по региону, отрасли и уровню ожидаемой заработной платы, просматривать детали вакансии, сохранять информацию о понравивших вакансиях на устройстве.<br>

### Стек технологий: 
- Android Studio
- Coroutines + Flow
- MVVM, LiveData
- Retrofit2
- Room Persistent Library
- Koin

## Развертывание и использование

1. Клонируйте репозиторий:
    ```text
    git clone https://github.com/Jahnta/Playlist-Maker.git
    ```

2. Откройте проект в Android Studio.

3. Осуществите сборку проекта и запустите на эмуляторе или физическом устройстве.

## Добавление секретного токена для API HeadHunter

Для отображения в приложении контактных данных рекрутеров, необходимо получить токен уровня application, для чего:
1. Создайте аккаунт на сайте HeadHunter.
2. Подать заявку на регистрацию приложения.
3. После одобрения заявки использовать полученные Client ID и Client Secret, чтобы выполнить запрос на получение токена.

Для проброса секретного токена, полученного после регистрации приложения для использования API HeadHunter, создайте в
корне проекта файл `develop.properties` и добавьте туда одно свойство:

```properties
hhAccessToken=my_access_token
```

Вместо `my_access_token` вставьте полученный после регистрации токен доступа к API HeadHunter. После изменения значения
синхронизируйте проект.

## Создатели

Ксения Аверкиева<br>
Денис Брусов<br>
Андрей Коммисаров<br>
Дмитрий Падчин

### Contact me 

<p align="left">
[![](https://img.shields.io/badge/Telegram-0077B5?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/jahnta)
</p>
