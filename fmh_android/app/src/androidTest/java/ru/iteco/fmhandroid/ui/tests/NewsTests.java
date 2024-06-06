package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static ru.iteco.fmhandroid.ui.data.NewsData.advertisement;
import static ru.iteco.fmhandroid.ui.data.NewsData.birthday;
import static ru.iteco.fmhandroid.ui.data.NewsData.gratitude;
import static ru.iteco.fmhandroid.ui.data.NewsData.help;
import static ru.iteco.fmhandroid.ui.data.NewsData.holiday;
import static ru.iteco.fmhandroid.ui.data.NewsData.massage;
import static ru.iteco.fmhandroid.ui.data.NewsData.salary;
import static ru.iteco.fmhandroid.ui.data.NewsData.union;

import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.data.NewsData;
import ru.iteco.fmhandroid.ui.data.ViewActions;
import ru.iteco.fmhandroid.ui.elements.CreateAndEditElements;
import ru.iteco.fmhandroid.ui.steps.BaseClass;
import ru.iteco.fmhandroid.ui.steps.CreateNewsPage;
import ru.iteco.fmhandroid.ui.steps.EditNewsPage;
import ru.iteco.fmhandroid.ui.steps.FilterNewsPage;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelPage;
import ru.iteco.fmhandroid.ui.steps.NewsPage;
import ru.iteco.fmhandroid.ui.steps.ToastMatcherSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTests extends BaseClass {

    NewsData newsData = new NewsData();
    NewsPage newsPage = new NewsPage();
    NewsControlPanelPage newsControlPanelPage = new NewsControlPanelPage();
    CreateNewsPage createNewsPage = new CreateNewsPage();
    CreateAndEditElements createAndEditElements = new CreateAndEditElements();
    ToastMatcherSteps toastMatcherSteps = new ToastMatcherSteps();
    EditNewsPage editNewsPage = new EditNewsPage();
    FilterNewsPage filterNewsPage = new FilterNewsPage();
    ViewActions viewActions = new ViewActions();

    private void createAndEditNews(String category, String title, String publicDate, String publicTime, String description, String editDescriptionText, int index) {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.fillCategoryField(category);
        createNewsPage.inputTextToTitleField(title);
        createNewsPage.fillPublicationDateField(publicDate);
        createNewsPage.fillTimeField(publicTime);
        createNewsPage.inputTextToDescriptionField(description);
        closeSoftKeyboard();
        createNewsPage.clickSaveButton();
        newsControlPanelPage.clickEditSelectedNews(index);
        editNewsPage.viewEditingNewsElements();
        editNewsPage.changeNewsDescription(editDescriptionText);
        closeSoftKeyboard();
    }

    private void assertNewsNotInList(String title) {
        List<String> newsTitles = viewActions.getNewsTitles();
        assertFalse("Новость с заголовком '" + title + "' не была удалена.", newsTitles.contains(title));
    }

    @Test
    @DisplayName("Создание новости категории \"Объявление\"")
    @Description("Успешное добавление новой новости категории \"Объявление\"")
    public void testCreateNewsAdvertisement() {
        createNews(advertisement, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
    }

    @Test
    @DisplayName("Создание новости категории \"День рождения\"")
    @Description("Успешное добавление новой новости категории \"День рождения\"")
    public void testCreateNewsBirthday() {
        createNews(birthday, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
    }

    @Test
    @DisplayName("Создание новости категории \"Зарплата\"")
    @Description("Успешное добавление новой новости категории \"Зарплата\"")
    public void testCreateNewsSalary() {
        createNews(salary, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
    }

    @Test
    @DisplayName("Создание новости категории \"Профсоюз\"")
    @Description("Успешное добавление новой новости категории \"Профсоюз\"")
    public void testCreateNewsUnion() {
        createNews(union, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
    }

    @Test
    @DisplayName("Создание новости категории \"Праздник\"")
    @Description("Успешное добавление новой новости категории \"Праздник\"")
    public void testCreateNewsHoliday() {
        createNews(holiday, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
    }

    @Test
    @DisplayName("Создание новости категории \"Массаж\"")
    @Description("Успешное добавление новой новости категории \"Массаж\"")
    public void testCreateNewsMassage() {
        createNews(massage, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
    }

    @Test
    @DisplayName("Создание новости категории \"Благодарность\"")
    @Description("Успешное добавление новой новости категории \"Благодарность\"")
    public void testCreateNewsGratitude() {
        createNews(gratitude, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
    }

    @Test
    @DisplayName("Создание новости категории \"Нужна помощь\"")
    @Description("Успешное добавление новой новости категории \"Нужна помощь\"")
    public void testCreateNewsHelp() {
        createNews(help, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
    }

    @Test
//    Негативный тест
    @DisplayName("XSS-инъекция в поле \"Категория\"")
    @Description("При введении XSS-инъекции в поле \"Категория\" новость не должна создаваться")
    public void testCreateNewsWithXSSInjection() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.createNews(newsData.xssToCategory, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
        createNewsPage.clickSaveButton();
        toastMatcherSteps.checkErrorSavingNewsToast();
    }

    @Test
//    Негативный тест
    @DisplayName("SQL-инъекция в поле \"Категория\"")
    @Description("При введении SQL-инъекции в поле \"Категория\" новость не должна создаваться")
    public void testCreateNewsWithSQLInjection() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.createNews(newsData.sqlToCategory, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
        createNewsPage.clickSaveButton();
        toastMatcherSteps.checkErrorSavingNewsToast();
    }

    @Test
//    Негативный тест
    @DisplayName("Создание новости с пустым полем \"Категория\"")
    @Description("Неудачная попытка добавить новость с пустым обязательным полем \"Категория\"")
    public void testCreateNewsWithEmptyCategory() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.createNews(newsData.emptyCategory, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
        createNewsPage.clickSaveButton();
        toastMatcherSteps.checkFillEmptyFieldsError();
    }

    @Test
//    Негативный тест
    @DisplayName("Создание новости с несуществующей категорией")
    @Description("Неудачная попытка добавить новость с несуществующей категорией")
    public void failedTestCreateNewsWithWrongCategory() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.createNews(newsData.wrongCategory, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
        createNewsPage.clickSaveButton();
        toastMatcherSteps.checkSelectCategoryToast();
    }

    @Test
//    Негативный тест
    @DisplayName("Создание новости на арабской вязи в поле \"Заголовок\"")
    @Description("Неудачная попытка добавить новость на арабской вязи в поле \"Заголовок\"")
    public void failedTestCreateNewsWithArabicTitle() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.createNews(help, newsData.arabicTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
        createNewsPage.clickSaveButton();
        toastMatcherSteps.checkFillEmptyFieldsError();
    }

    @Test
    @DisplayName("Создание новости с заполнением времени через клавиатуру, а не через clockpicker")
    @Description("Добавление новости с введением времени в поле \"Время\" через клавиатуру")
    public void testCreateNewsWithTimeThroughKeyboard() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.fillCategoryField(advertisement);
        createNewsPage.inputTextToTitleField(newsData.randomTitle);
        createNewsPage.fillPublicationDateField(newsData.publicDate);
        createNewsPage.fillTimeFieldWithKeyboard(newsData.validHours, newsData.validMinutes);
        createNewsPage.clickOkButton();
        createNewsPage.inputTextToDescriptionField(newsData.randomDescription);
        createNewsPage.clickSaveButton();
        mainPage.openNewsMenuBlock();
        newsPage.viewNewsList();
        mainPage.openOneNewsBlock(0);
        String checkedNewsDescription = newsPage.getNewsDescription(0);
        assertEquals(newsData.randomDescription, checkedNewsDescription);
    }

    @Test
//    Негативный тест
    @DisplayName("Создание новости с указанием несуществующего времени в поле \"Время\"")
    @Description("Неудачная попытка добавления новости с введением несуществующего времени в поле \"Время\"")
    public void testCreateNewsWithWrongTime() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.fillCategoryField(advertisement);
        createNewsPage.inputTextToTitleField(newsData.randomTitle);
        createNewsPage.fillPublicationDateField(newsData.publicDate);
        createNewsPage.fillTimeFieldWithKeyboard(newsData.wrongHours, newsData.wrongMinutes);
        createNewsPage.clickOkButton();
        createAndEditElements.wrongTimeError.check(matches(isDisplayed()));
    }

    @Test
//    Негативный тест
    @DisplayName("Создание новости со всеми пустыми полями")
    @Description("Неудачная попытка сохранения новости со всеми пустыми полями")
    public void testCreateNewsWithEmptyFields() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.clickSaveButton();
        toastMatcherSteps.checkFillEmptyFieldsError();
    }

    @Test
    @DisplayName("Отмена создания новости, не сохраняя ее")
    @Description("Созданная новость не сохраняется при нажатии кнопки \"ОТМЕНА\"")
    public void testCancelNewsCreation() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.fillCategoryField(birthday);
        createNewsPage.clickCancelButton();
        createNewsPage.clickOkButton();
        newsControlPanelPage.viewControlPanelIcons();
    }

    @Test
    @DisplayName("Отказ от отмены создания новости")
    @Description("Возращение к добавлению новости после отказа от отмены создания новости")
    public void testRefusalToCancelNewsCreation() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.fillCategoryField(salary);
        createNewsPage.clickCancelButton();
        createAndEditElements.cancelChangesNewsMessage.check(matches(isDisplayed()));
        createNewsPage.clickMiniCancelButton();
        createNewsPage.viewCreatingNewsElements();
    }

    @Test
    @DisplayName("Редактирование новости")
    @Description("Отредактированная новость успешно сохраняется")
    public void testEditNews() {
        createAndEditNews(union, newsData.randomTitle, newsData.publicDate,
                newsData.publicTime, newsData.randomDescription,
                newsData.editDescriptionText, 0);
        createNewsPage.clickSaveButton();
        newsControlPanelPage.clickOneNewsBlock(0);
        assertEquals(newsData.editDescriptionText, newsControlPanelPage.getNewsDescription(0));
    }

    @Test
    @DisplayName("Смена статуса новости с \"АКТИВНА\" на \"НЕ АКТИВНА\"")
    @Description("Смена статуса новости с \"АКТИВНА\" на \"НЕ АКТИВНА\" при редактировании новости")
    public void testEditStatusNews() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.createNews(help, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
        createNewsPage.clickSaveButton();
        newsControlPanelPage.viewControlPanelIcons();
        newsControlPanelPage.clickEditSelectedNews(0);
        editNewsPage.viewEditingNewsElements();
        editNewsPage.changeNewsStatus();
        createNewsPage.clickSaveButton();
        newsControlPanelPage.viewControlPanelIcons();
        newsControlPanelPage.checkInactiveNewsStatus(0);
    }

    @Test
    @DisplayName("Отмена редактирования новости")
    @Description("Внесенные изменения не сохраняются при нажатии кнопки \"ОТМЕНА\"")
    public void testCancelEditNews() {
        createAndEditNews(massage, newsData.randomTitle, newsData.publicDate,
                newsData.publicTime, newsData.randomDescription,
                newsData.editDescriptionText, 0);
        createNewsPage.clickCancelButton();
        createNewsPage.clickOkButton();
        mainPage.openNewsMenuBlock();
        newsControlPanelPage.clickOneNewsBlock(0);
        String notEditDescription = newsControlPanelPage.getNewsDescription(0);
        assertEquals(newsData.randomDescription, notEditDescription);
    }

    @Test
    @DisplayName("Удаление созданной новости")
    @Description("Успешное удаление созданной новости в панели управления")
    public void testDeleteNews() {
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.createNews(help, newsData.randomTitle,
                newsData.publicDate, newsData.publicTime,
                newsData.randomDescription);
        createNewsPage.clickSaveButton();
        newsControlPanelPage.viewControlPanelIcons();
        newsControlPanelPage.clickDeleteSelectedNews(0);
        createNewsPage.clickOkButton();
        assertNewsNotInList(newsData.randomTitle);
    }

    @Test
    @DisplayName("Сортировка новостей на странице \"Новости\" ")
    @Description("Создание максимально возможных для отображения на странице" +
            " новостей для применения сортировки по дате создания от поздней новости к ранней")
    public void testSortNews() {

        List<Map<String, String>> newsToCreate = new ArrayList<>();
        newsToCreate.add(createNewsMap(help, "SortTitle1", newsData.publicDate,
                newsData.publicTime, "Description 1"));
        newsToCreate.add(createNewsMap(help, "SortTitle2", newsData.publicDate,
                newsData.publicTime, "Description 2"));
        newsToCreate.add(createNewsMap(advertisement, "SortTitle3", newsData.publicDate,
                newsData.publicTime, "Description 3"));
        newsToCreate.add(createNewsMap(massage, "SortTitle4", newsData.publicDate,
                newsData.publicTime, "Description 4"));
        newsToCreate.add(createNewsMap(union, "SortTitle5", newsData.publicDate,
                newsData.publicTime, "Description 5"));
        newsToCreate.add(createNewsMap(help, "SortTitle6", newsData.publicDate,
                newsData.publicTime, "Description 6"));
        newsToCreate.add(createNewsMap(salary, "SortTitle7", newsData.publicDate,
                newsData.publicTime, "Description 7"));
        newsToCreate.add(createNewsMap(salary, "SortTitle8", newsData.publicDate,
                newsData.publicTime, "Description 8"));

        createMultipleNews(newsToCreate);

        mainPage.openNewsMenuBlock();

        newsPage.clickSortNews();

        String firstNewsTitle = newsPage.getSelectedNewsTitle(0);
        assertNotEquals("SortTitle1", firstNewsTitle, "Первая новость не должна быть 'SortTitle1'");
    }

    @Test
    @DisplayName("Фильтр новостей по дате публикации")
    @Description("При фильтре новостей по дате в далеком прошлом список новостей пуст")
    public void testCheckFilterActiveNotActive() {
        List<Map<String, String>> newsToCreate = Arrays.asList(
                createNewsMap(help, "FilterTitle1", newsData.publicDate,
                        newsData.publicTime, "Description 1"),
                createNewsMap(help, "FilterTitle2", newsData.publicDate,
                        newsData.publicTime, "Description 2")
        );

        createMultipleNews(newsToCreate);

        mainPage.openNewsMenuBlock();
        newsPage.viewNewsList();

        // Проверяем, что новости действительно созданы и отображаются
        for (Map<String, String> news : newsToCreate) {
            assertTrue("Новость с заголовком '" + news.get("title") + "' не найдена.",
                    newsPage.hasNewsWithTitle(news.get("title")));
        }

        // Применяем фильтр по дате в прошлом
        newsPage.clickFilterNews();
        filterNewsPage.viewFilterNewsElements();
        filterNewsPage.fillStartDateField(newsData.publicDateInPast);
        filterNewsPage.fillEndDateField(newsData.publicDateInPast);
        filterNewsPage.clickFilterButton();

        // Проверяем, что список новостей пуст
        newsPage.checkNewsListWithoutNews();

        // Дополнительно: проверяем, что ранее созданные новости не отображаются
        for (Map<String, String> news : newsToCreate) {
            assertFalse("Новость с заголовком '" + news.get("title") + "' не должна отображаться.",
                    newsPage.hasNewsWithTitle(news.get("title")));
        }
    }
}
