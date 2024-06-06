package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.data.ViewActions.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.ViewActions.withIndex;
import static ru.iteco.fmhandroid.ui.elements.NewsPageElements.getDescriptionTextNewsView;
import static ru.iteco.fmhandroid.ui.elements.NewsPageElements.getNewsMainList;
import static ru.iteco.fmhandroid.ui.elements.NewsPageElements.getNewsTitleText;

import androidx.test.espresso.NoMatchingViewException;

import junit.framework.AssertionFailedError;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.ViewActions;
import ru.iteco.fmhandroid.ui.elements.MainPageElements;
import ru.iteco.fmhandroid.ui.elements.NewsPageElements;

public class NewsPage {
    MainPageElements mainPageElements = new MainPageElements();
    NewsPageElements newsPageElements = new NewsPageElements();

    public void checkNewsElements() {
        Allure.step("Отображение элементов страницы \"Новости\"");
        mainPageElements.checkTitleNews.check(matches(isDisplayed()));
        newsPageElements.allNewsBlock.check(matches(isDisplayed()));
    }

    public void viewNewsList() {
        Allure.step("Отображение списка всех новостей");
        elementWaiting(getNewsMainList(), 3000);
    }

    public void clickSortNews() {
        Allure.step("Нажать кнопку сортировки");
        newsPageElements.sortNewsButton.check(matches(isDisplayed()));
        newsPageElements.sortNewsButton.perform(click());
    }

    public void clickFilterNews() {
        Allure.step("Нажать кнопку фильтрации");
        newsPageElements.filterNewsButton.check(matches(isDisplayed()));
        newsPageElements.filterNewsButton.perform(click());
    }

    public void clickEditNews() {
        Allure.step("Нажатие кнопки редактирования новостей");
        newsPageElements.editNewsButton.check(matches(isDisplayed()));
        newsPageElements.editNewsButton.perform(click());
    }

    public String getSelectedNewsTitle(int index) {
        Allure.step("Текст заголовка выбранной новости");
        return ViewActions.Text.getText(onView(withIndex(getNewsTitleText(), index)));
    }

    public String getNewsDescription(int index) {
        Allure.step("Текст описания выбранной новости");
        return ViewActions.Text.getText(onView(withIndex(getDescriptionTextNewsView(), index)));
    }

    public void checkNewsListWithoutNews() {
        Allure.step("Отсутствие новостей в списке");
        try {
            onView(withId(R.id.news_list_recycler_view))
                    .check(matches(hasChildCount(0)));
        } catch (AssertionFailedError e) {
            throw new AssertionError("Список новостей не пуст, хотя должен быть.");
        }
    }

    public boolean hasNewsWithTitle(String title) {
        Allure.step("Проверка наличия новости с заголовком: " + title);
        try {
            onView(allOf(
                    isDescendantOfA(withId(R.id.news_list_recycler_view)),
                    withText(title)
            )).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException | AssertionFailedError e) {
            return false;
        }
    }
}