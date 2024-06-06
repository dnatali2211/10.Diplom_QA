package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.data.ViewActions.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.ViewActions.waitForElement;
import static ru.iteco.fmhandroid.ui.data.ViewActions.withIndex;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.ViewActions;
import ru.iteco.fmhandroid.ui.elements.MainPageElements;
import ru.iteco.fmhandroid.ui.elements.NewsPageElements;

public class MainPage {
    MainPageElements mainPageElements = new MainPageElements();
    NewsPageElements newsPageElements = new NewsPageElements();

    public void logOut() {
        Allure.step("Выйти из аккаунта");
        mainPageElements.accountButton.perform(click());
        onView(isRoot()).perform(waitForElement((allOf(withId(android.R.id.title), withText("Выйти"))), 1000));
        mainPageElements.logOutButton.check(matches(isDisplayed()));
        mainPageElements.logOutButton.perform(click());
    }

    public void mainPageLoad() {
        Allure.step("Загрузка главной страницы");
        elementWaiting(withId(R.id.all_news_text_view), 2000);
    }

    public void clickAllNewsButton() {
        Allure.step("Нажать на кнопку \"ВСЕ НОВОСТИ\"");
        elementWaiting(withId(R.id.all_news_text_view), 2000);
        mainPageElements.allNewsButton.perform(click());
    }

    public void openOneNewsBlock(int position) {
        Allure.step("Раскрыть описание одной новости");
        mainPageElements.checkTitleNews.check(matches(isDisplayed()));
        mainPageElements.oneNewsBlockMainPage.perform(actionOnItemAtPosition(position, click()));
    }

    public void descriptionIsDisplayed(int position) {
        Allure.step("Отображение описания выбранной новости");
        String descriptionText = ViewActions.Text.getText(onView(withIndex(newsPageElements.getDescriptionTextNewsView(), position)));
        onView(allOf(withText(descriptionText), isDisplayed())).check(matches(isDisplayed()));
    }

    public void clickHideExpendAllNewsButton() {
        Allure.step("Нажать на кнопку-стрелку скрытия/раскрытия блока новостей");
        mainPageElements.hideExpandAllNewsButton.check(matches(isDisplayed()));
        mainPageElements.hideExpandAllNewsButton.perform(click());
    }

    public void checkHideAllNews() {
        Allure.step("Блок всех новостей скрыт");
        mainPageElements.allNewsButton.check(matches(not(isDisplayed())));
    }

    public void openNewsMenuBlock() {
        Allure.step("Переход в раздел \"Новости\"");
        mainPageElements.hamburgerButton.perform(click());
        mainPageElements.newsPageButton.check(matches(isDisplayed()));
        mainPageElements.newsPageButton.perform(click());
    }

    public void openAboutAppMenuBlock() {
        Allure.step("Переход в раздел \"О приложении\"");
        mainPageElements.hamburgerButton.perform(click());
        mainPageElements.aboutOfApp.check(matches(isDisplayed()));
        mainPageElements.aboutOfApp.perform(click());
    }

    public void openMainMenuBlock() {
        Allure.step("Переход в раздел \"Главная\"");
        elementWaiting(withId(R.id.main_menu_image_button), 1000);
        mainPageElements.hamburgerButton.perform(click());
        mainPageElements.mainPageButton.check(matches(isDisplayed()));
        mainPageElements.mainPageButton.perform(click());
    }

    public void openQuotesPage() {
        Allure.step("Переход на страницу с цитатами");
        mainPageElements.quotesButton.check(matches(isDisplayed()));
        mainPageElements.quotesButton.perform(click());
    }
}
