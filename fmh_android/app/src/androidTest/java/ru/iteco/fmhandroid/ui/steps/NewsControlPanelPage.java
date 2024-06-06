package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.ViewActions.elementWaiting;
import static ru.iteco.fmhandroid.ui.data.ViewActions.withIndex;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelElements.getButtonDeleteNews;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelElements.getButtonEditNews;
import static ru.iteco.fmhandroid.ui.elements.NewsPageElements.getDescriptionTextNewsView;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelElements;
import ru.iteco.fmhandroid.ui.elements.NewsPageElements;

public class NewsControlPanelPage {
    NewsPageElements newsPageElements = new NewsPageElements();
    NewsControlPanelElements newsControlPanelElements = new NewsControlPanelElements();

    public void viewControlPanelIcons() {
        Allure.step("Отображение иконок на панели управления");
        elementWaiting(withId(R.id.filter_news_material_button), 2000);
        newsPageElements.filterNewsButton.check(matches(isDisplayed()));
        newsPageElements.sortNewsButton.check(matches(isDisplayed()));
        newsControlPanelElements.createNewsButton.check(matches(isDisplayed()));
    }

    public void clickCreateNewsButton() {
        Allure.step("Нажать на кнопку создания новости");
        newsControlPanelElements.createNewsButton.perform(click());
    }

    public void clickDeleteSelectedNews(int index) {
        Allure.step("Нажать на кнопку удаления выбранной новости");
        onView(withIndex(getButtonDeleteNews(), index)).perform(click());
        newsControlPanelElements.messageAboutDelete.check(matches(isDisplayed()));
    }

    public void clickEditSelectedNews(int index) {
        Allure.step("Нажать на кнопку редактирования выбранной новости");
        onView(withIndex(getButtonEditNews(), index)).perform(click());
        elementWaiting((withId(R.id.custom_app_bar_title_text_view)), 3000);
    }

    public void clickOneNewsBlock(int index) {
        Allure.step("Нажать любую новость");
        newsControlPanelElements.oneNewsBlockPanel.perform(actionOnItemAtPosition(index, click()));
    }

    public String getNewsDescription(int index) {
        Allure.step("Текст описания выбранной новости");
        return ru.iteco.fmhandroid.ui.data.ViewActions.Text.getText(onView(withIndex(getDescriptionTextNewsView(), index)));
    }

    public void checkInactiveNewsStatus(int index) {
        Allure.step("Статус новости \"Не активна\"");
        onView(withIndex(withId(R.id.news_item_published_text_view), index))
                .check(matches(withText("НЕ АКТИВНА")));
    }
}
