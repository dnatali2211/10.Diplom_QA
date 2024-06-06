package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.CreateAndEditElements;

public class EditNewsPage {
    CreateAndEditElements createAndEditElements = new CreateAndEditElements();

    public void viewEditingNewsElements() {
        Allure.step("Отображение элементов страницы редактирования новости");
        createAndEditElements.editingNewsPageTitle.check(matches(isDisplayed()));
        createAndEditElements.categoryField.check(matches(isDisplayed()));
        createAndEditElements.titleField.check(matches(isDisplayed()));
        createAndEditElements.publicationDateField.check(matches(isDisplayed()));
        createAndEditElements.publicationTimeField.check(matches(isDisplayed()));
        createAndEditElements.descriptionField.check(matches(isDisplayed()));
        createAndEditElements.statusSwitcher.check(matches(isDisplayed()));
    }

    public void changeNewsStatus() {
        Allure.step("Изменить статус новости");
        createAndEditElements.statusSwitcher.perform(click());
    }

    public void changeNewsTitle(String text) {
        Allure.step("Редактировать заголовок новости");
        createAndEditElements.titleField.perform(replaceText(text));
    }

    public void changeNewsDescription(String text) {
        Allure.step("Редактировать описание новости");
        createAndEditElements.descriptionField.perform(click());
        createAndEditElements.descriptionField.perform(clearText());
        createAndEditElements.descriptionField.perform(replaceText(text));
    }
}
