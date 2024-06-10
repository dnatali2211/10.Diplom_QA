# Дипломный проект по профессии «Инженер по тестированию»

## Процедура запусков автотестов мобильного приложения «В Хосписе»

[Задание проекта](https://github.com/netology-code/qamid-diplom)

Приложение даёт функционал по работе с новостями хосписа и включает в себя:

- информацию о новостях и функционал для работы с ними;
- тематические цитаты;
- информацию о приложении.

## Требования к окружению

- Java Development Kit (JDK) 8;
- Android Studio Jellyfish | 2023.3.1;
- Android SDK Platform-Tools 29;
- эмулятор Android или физическое устройство с API 29.

## Документация

- [План по проверке и автоматизации приложения](https://github.com/dnatali2211/10.Diplom_QA/blob/main/Plan.md)
- [Чек-лист проекта](https://github.com/dnatali2211/10.Diplom_QA/blob/main/Check.xlsx)
- [Тест-кейсы](https://github.com/dnatali2211/10.Diplom_QA/blob/main/Cases.xlsx)
- [Отчет о результатах тестирования](https://github.com/dnatali2211/10.Diplom_QA/blob/main/Result.md)

## Структура проекта

- `app/` - исходный код приложения;
- `app/src/androidTest/` - пакет с автотестами;
  - `ui/elements/` - классы ui-элементов страниц приложения;
  - `ui/steps/` - шаги для улучшения читаемости тестов;
  - `ui/tests/` - классы тестов;
- `allure-results/` - результаты для Allure.

## Подготовка к запуску

1. Убедитесь, что у вас установлены JDK и Android Studio.
2. В Android Studio, перейдите в `Tools > SDK Manager`.
3. Установите `Android 10.0 (Q) SDK` и `Android Emulator`.
4. Создайте эмулятор Pixel 5 с API 29 через `Tools > AVD Manager`.
5. На локальном компьютере откройте терминал.
6. Склонируйте репозиторий командой `git clone https://github.com/dnatali2211/10.Diplom_QA.git`.
7. Откройте проект в Android Studio.
8. Запустите приложение app на эмуляторе Pixel 5 API 29.
9. Если на эмуляторе дефолтный язык системы - английский, то зайти в настройки эмулятора 
    Settings => System => Languages and input => Languages => Add a language => Русский (Россия) => 
    перетащить русский язык на первое место.
10. Запустите тесты из командной строки`./gradlew connectedAndroidTest`.
11. Дождитесь результатов.