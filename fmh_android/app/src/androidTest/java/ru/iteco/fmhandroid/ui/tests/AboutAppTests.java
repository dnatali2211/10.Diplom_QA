package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static org.hamcrest.Matchers.allOf;

import android.content.Intent;
import android.net.Uri;

import androidx.test.espresso.intent.Intents;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.steps.AboutAppPage;
import ru.iteco.fmhandroid.ui.steps.BaseClass;

@RunWith(AllureAndroidJUnit4.class)
public class AboutAppTests extends BaseClass {

    AboutAppPage aboutAppPage = new AboutAppPage();

    @Before
    public void setUp() {
        // Инициализация Espresso Intents
        Intents.init();
    }

    @After
    public void tearDown() {
        // Освобождение ресурсов Espresso Intents
        Intents.release();
    }

    @Test
    @DisplayName("Открытие ссылки \"Политика конфиденциальности\"")
    @Description("При нажатии на ссылку \"Политика конфиденциальности\" " +
            "происходит переход на указанный URL")
    public void testPrivacyPolicyLinkClickOpensBrowser() {
        mainPage.openAboutAppMenuBlock();
        aboutAppPage.checkScreenElementsAbout();
        aboutAppPage.clickPrivacyPolicyLink();

        // Проверить, что Intent с ACTION_VIEW и правильным URI был запущен
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("https://vhospice.org/#/privacy-policy"))
        ));
    }

    @Test
    @DisplayName("Открытие ссылки \"Пользовательское соглашение\"")
    @Description("При нажатии на ссылку \"Пользовательское соглашение\" " +
            "происходит переход на указанный URL")
    public void testPrivacyTermsOfUseClickOpensBrowser() {
        mainPage.openAboutAppMenuBlock();
        aboutAppPage.checkScreenElementsAbout();
        aboutAppPage.clickTermsOfUseLink();

        // Проверить, что Intent с ACTION_VIEW и правильным URI был запущен
        intended(allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse("https://vhospice.org/#/terms-of-use"))
        ));
    }

    @Test
    @DisplayName("Возврат на главную страницу со страницы \"О приложении\"")
    @Description("При нажатиии кнопки-стрелки \"Назад\" происходит возврат на главную страницу")
    public void testCheckReturnToMainPage() {
        mainPage.openAboutAppMenuBlock();
        aboutAppPage.checkScreenElementsAbout();
        aboutAppPage.clickReturnButton();
        mainPage.mainPageLoad();
    }
}
