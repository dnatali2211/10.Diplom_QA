package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.ViewActions.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.CreateAndEditElements;

public class CreateNewsPage {
    CreateAndEditElements createAndEditElements = new CreateAndEditElements();

    public void viewCreatingNewsElements() {
        Allure.step("Отображение элементов страницы создания новости");
        createAndEditElements.creatingNewsPageTitle.check(matches(isDisplayed()));
        createAndEditElements.categoryField.check(matches(isDisplayed()));
        createAndEditElements.titleField.check(matches(isDisplayed()));
        createAndEditElements.publicationDateField.check(matches(isDisplayed()));
        createAndEditElements.publicationTimeField.check(matches(isDisplayed()));
        createAndEditElements.descriptionField.check(matches(isDisplayed()));
    }

    public void fillCategoryField(String text) {
        Allure.step("Заполнение поля \"Категория\"");
        createAndEditElements.categoryField.perform(replaceText(text));
    }

    public void inputTextToTitleField(String text) {
        Allure.step("Заполнение поля \"Заголовок\"");
        createAndEditElements.titleField.perform(replaceText(text));
    }

    public void fillPublicationDateField(String text) {
        Allure.step("Заполнение поля \"Дата публикации\"");
        createAndEditElements.publicationDateField.perform(replaceText(text));
    }

    public void fillTimeField(String text) {
        Allure.step("Заполнение поля \"Время\"");
        createAndEditElements.publicationTimeField.perform(replaceText(text));
    }

    public void fillTimeFieldWithKeyboard(String hours, String minutes) {
        Allure.step("Заполнение поля \"Время\" с помощью клавиатуры");
        createAndEditElements.publicationTimeField.perform(click());
        createAndEditElements.buttonKeyboardForTime.perform(click());
        createAndEditElements.hoursField.perform(click(), replaceText(hours), closeSoftKeyboard());
        createAndEditElements.minutesField.perform(click(), replaceText(minutes), closeSoftKeyboard());
    }

    public void inputTextToDescriptionField(String text) {
        Allure.step("Заполнение поля \"Описание\"");
        createAndEditElements.descriptionField.perform(replaceText(text));
    }

    public void createNews(String category, String title, String publicationDate,
                           String publicationTime, String description) {
        Allure.step("Создание новости");
        fillCategoryField(category);
        inputTextToTitleField(title);
        fillPublicationDateField(publicationDate);
        fillTimeField(publicationTime);
        inputTextToDescriptionField(description);
        closeSoftKeyboard();
    }

    public void clickSaveButton() {
        Allure.step("Нажать кнопку \"Сохранить\"");
        createAndEditElements.saveButton.check(matches(isDisplayed()));
        createAndEditElements.saveButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажать кнопку \"Отмена\"");
        createAndEditElements.cancelButton.check(matches(isDisplayed()));
        createAndEditElements.cancelButton.perform(click());
    }

    public void clickOkButton() {
        Allure.step("Нажать кнопку \"OK\"");
        elementWaiting(withId(android.R.id.button1), 1000);
        createAndEditElements.okButton.perform(click());
    }

    public void clickMiniCancelButton() {
        Allure.step("Нажать кнопку \"Отмена\" в модальном окне отмены создаваемой новости");
        elementWaiting(withId(android.R.id.button2), 1000);
        createAndEditElements.miniCancelButton.perform(click());
    }
}
