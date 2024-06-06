package ru.iteco.fmhandroid.ui.steps;

import static org.junit.Assert.assertTrue;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.validCredentials;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.AppActivity;

public class BaseClass {

    protected AuthPage authPage = new AuthPage();
    protected MainPage mainPage = new MainPage();
    protected SplashScreenPage splashScreenPage = new SplashScreenPage();
    protected NewsPage newsPage = new NewsPage();
    protected NewsControlPanelPage newsControlPanelPage = new NewsControlPanelPage();
    protected CreateNewsPage createNewsPage = new CreateNewsPage();

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void setup() {
        splashScreenPage.appDownloading();
        try {
            authPage.loadAuthPage();
            authPage.checkAuthPage();
        } catch (Exception e) {
            mainPage.logOut();
            authPage.loadAuthPage();
        }
        login();
    }

    public void login() {
        Allure.step("Аутентификация с валидными данными");
        authPage.loginValidCredentials(validCredentials());
        authPage.clickSignInButton();
        mainPage.mainPageLoad();
    }

    public void createNews(String category, String title, String publicDate,
                           String publicTime, String description) {
        Allure.step("Создать новость");
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        newsControlPanelPage.clickCreateNewsButton();
        createNewsPage.viewCreatingNewsElements();
        createNewsPage.createNews(category, title, publicDate, publicTime, description);
        createNewsPage.clickSaveButton();
        mainPage.openMainMenuBlock();

        boolean isTitleFound = newsPage.hasNewsWithTitle(title);
        assertTrue("Новость с заголовком '" + title + "' не найдена.", isTitleFound);
    }

    public void createMultipleNews(List<Map<String, String>> newsToCreate) {
        Allure.step("Создать несколько новостей");
        mainPage.openNewsMenuBlock();
        newsPage.clickEditNews();
        for (Map<String, String> news : newsToCreate) {
            newsControlPanelPage.clickCreateNewsButton();
            createNewsPage.viewCreatingNewsElements();
            createNewsPage.createNews(
                    news.get("category"), news.get("title"),
                    news.get("publicDate"), news.get("publicTime"),
                    news.get("description")
            );
            createNewsPage.clickSaveButton();
            newsControlPanelPage.viewControlPanelIcons();
        }
    }

    public Map<String, String> createNewsMap(String category, String title,
                                             String publicDate, String publicTime,
                                             String description) {
        Map<String, String> newsMap = new HashMap<>();
        newsMap.put("category", category);
        newsMap.put("title", title);
        newsMap.put("publicDate", publicDate);
        newsMap.put("publicTime", publicTime);
        newsMap.put("description", description);
        return newsMap;
    }
}
