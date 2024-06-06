package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.FilterNewsElements;

public class FilterNewsPage {
    FilterNewsElements filterNewsElements = new FilterNewsElements();

    public void viewFilterNewsElements() {
        Allure.step("Отображение элементов страницы фильтрации новостей");
        filterNewsElements.filterNewsPageTitle.check(matches(isDisplayed()));
        filterNewsElements.categoryField.check(matches(isDisplayed()));
        filterNewsElements.filterStartDateField.check(matches(isDisplayed()));
        filterNewsElements.filterEndDateField.check(matches(isDisplayed()));
    }

    public void clickFilterButton() {
        Allure.step("Нажать кнопку \"Фильтровать\"");
        filterNewsElements.filterButton.perform(click());
    }

    public void fillStartDateField(String startDate) {
        Allure.step("Заполнить поле начала периода фильтрации");
        filterNewsElements.filterStartDateField.perform(replaceText(startDate));
    }

    public void fillEndDateField(String endDate) {
        Allure.step("Заполнить поле окончания периода фильтрации");
        filterNewsElements.filterEndDateField.perform(replaceText(endDate));
    }
}
