package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.NewsData.birthday;
import static ru.iteco.fmhandroid.ui.data.NewsData.help;
import static ru.iteco.fmhandroid.ui.data.NewsData.salary;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.data.NewsData;
import ru.iteco.fmhandroid.ui.steps.AboutAppPage;
import ru.iteco.fmhandroid.ui.steps.BaseClass;

@RunWith(AllureAndroidJUnit4.class)
public class MainPageTests extends BaseClass {
    NewsData newsData = new NewsData();
    AboutAppPage aboutAppPage = new AboutAppPage();

    @Test
    @DisplayName("Перейти на страницу \"Новости\" с помощью нажатия кнопки \"ВСЕ НОВОСТИ\"")
    @Description("При нажатии кнопки \"ВСЕ НОВОСТИ\" происходит переход на страницу \"Новости\"")
    public void testAllNewsList() {
        createNews(help, newsData.randomTitle, newsData.publicDate,
                newsData.publicTime, newsData.randomDescription);
        mainPage.clickAllNewsButton();
        newsPage.viewNewsList();
    }

    @Test
    @DisplayName("Развернуть описание у выбранной новости")
    @Description("При нажатии на выбранную новость разворачивается ее описание")
    public void testOpenSeparateNewsDescription() {
        List<Map<String, String>> newsToCreate = Arrays.asList(
                createNewsMap(help, newsData.ruTitle, newsData.publicDate,
                        newsData.publicTime, newsData.ruDescription),
                createNewsMap(birthday, newsData.randomTitle, newsData.publicDate,
                        newsData.publicTime, newsData.randomDescription)
        );

        createMultipleNews(newsToCreate);

        mainPage.openNewsMenuBlock();
        mainPage.openOneNewsBlock(1);
        mainPage.descriptionIsDisplayed(1);
    }

    @Test
    @DisplayName("Переход с главной страницы на страницу \"Новости\"")
    @Description("Успешный переход с главной страницы на страницу \"Новости\"" +
            " с помощью нажатия меню-гамбургера")
    public void testGoToNewsPageFromMainPage() {
        mainPage.openNewsMenuBlock();
        newsPage.checkNewsElements();
    }

    @Test
    @DisplayName("Переход со страницы \"Новости\" на страницу \"О приложении\"")
    @Description("Успешный переход со страницы \"Новости\" на страницу \"О приложении\"" +
            " с помощью нажатия меню-гамбургера")
    public void failedTestGoToAboutPageFromNewsPage() {
        mainPage.openNewsMenuBlock();
        newsPage.checkNewsElements();
        mainPage.openAboutAppMenuBlock();
        aboutAppPage.checkScreenElementsAbout();
    }

    @Test
    @DisplayName("Переход с главной страницы на страницу \"О приложении\"")
    @Description("Успешный переход с главной страницы на страницу \"О приложении\"" +
            " с помощью нажатия меню-гамбургера")
    public void testGoToAboutPageFromMainPage() {
        mainPage.openAboutAppMenuBlock();
        aboutAppPage.checkScreenElementsAbout();
    }

    @Test
    @DisplayName("Развернуть и свернуть блок всех новостей")
    @Description("При нажатии на кнопку-стрелку скрытия/раскрытия всех новостей" +
            "список скрывается, а при повторном нажатии - раскрывается")
    public void testHideExpendListButton() {
        createNews(salary, newsData.randomTitle, newsData.publicDate,
                newsData.publicTime, newsData.randomDescription);
        newsPage.viewNewsList();
        mainPage.clickHideExpendAllNewsButton();
        mainPage.checkHideAllNews();
        mainPage.clickHideExpendAllNewsButton();
        newsPage.viewNewsList();
    }
}
