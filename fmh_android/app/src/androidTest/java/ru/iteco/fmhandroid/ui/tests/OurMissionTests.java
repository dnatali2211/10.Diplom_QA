package ru.iteco.fmhandroid.ui.tests;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.steps.BaseClass;
import ru.iteco.fmhandroid.ui.steps.MainPage;
import ru.iteco.fmhandroid.ui.steps.OurMissionPage;

@RunWith(AllureAndroidJUnit4.class)

public class OurMissionTests extends BaseClass {

    MainPage mainPage = new MainPage();
    OurMissionPage ourMissionPage = new OurMissionPage();

    @Test
    @DisplayName("Отображение страницы с цитатами")
    @Description("Страница \"Наша миссия\" открывается и отображается список цитат")
    public void testCheckMissionScreenElements() {
        mainPage.openQuotesPage();
        ourMissionPage.viewOurMissionPageElements();
    }

    @Test
    @DisplayName("Развернуть и свернуть цитату, во вкладке \"Love is all\" приложения")
    @Description("При нажатии - разворачивается содержимое цитаты")
    public void testExpandAndCollapseQuote() {
        mainPage.openQuotesPage();
        ourMissionPage.viewOurMissionPageElements();
        ourMissionPage.scrollToChoosenQuote(6);
        ourMissionPage.hideExpendQuote(6);
        ourMissionPage.toggleQuoteDescriptionDisplay("\"Делай добро... А добро заразительно. " +
                        "По-моему, все люди милосердны. Нужно просто говорить с ними об этом, суметь " +
                        "разбудить в них чувство сострадания, заложенное от рождения\" - В.В. Миллионщикова",
                true);
    }
}