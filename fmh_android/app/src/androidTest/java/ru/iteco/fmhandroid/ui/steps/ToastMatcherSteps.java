package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.IsNot.not;
import static ru.iteco.fmhandroid.ui.elements.ToastMatcherElements.getErrorSavingNews;
import static ru.iteco.fmhandroid.ui.elements.ToastMatcherElements.getFieldsCanNotBeEmpty;
import static ru.iteco.fmhandroid.ui.elements.ToastMatcherElements.getFillEmptyFields;
import static ru.iteco.fmhandroid.ui.elements.ToastMatcherElements.getSelectCategoryError;
import static ru.iteco.fmhandroid.ui.elements.ToastMatcherElements.getSomethingWentWrong;
import static ru.iteco.fmhandroid.ui.elements.ToastMatcherElements.getWrongLoginOrPassword;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.ToastMatcherElements;

public class ToastMatcherSteps {
    ToastMatcherElements toastMatcherElements = new ToastMatcherElements();

    public void checkToast(int id, boolean visible) {
        Allure.step((visible ? "Проверка отображения" : "Проверка скрытия") +
                " всплывающего сообщения с ID: " + id);
        if (visible) {
            toastMatcherElements.toastMatcher(id).check(matches(isDisplayed()));
        } else {
            toastMatcherElements.toastMatcher(id).check(matches(not(isDisplayed())));
        }
    }

    public void checkWrongLoginOrPasswordToast() {
        Allure.step("Видимость валидационного сообщения \"Неверный логин или пароль\"");
        checkToast(getWrongLoginOrPassword(), true);
    }

    public void checkSomethingWentWrongToast() {
        Allure.step("Видимость валидационного сообщения \"Что-то пошло не так. Попробуйте позднее.\"");
        checkToast(getSomethingWentWrong(), true);
    }

    public void checkFieldsCanNotBeEmptyToast() {
        Allure.step("Видимость валидационного сообщения \"Логин и пароль не могут быть пустыми\"");
        checkToast(getFieldsCanNotBeEmpty(), true);
    }

    public void checkFillEmptyFieldsError() {
        Allure.step("Видимость валидационного сообщения \"Заполните пустые поля\"");
        checkToast(getFillEmptyFields(), true);
    }

    public void checkErrorSavingNewsToast() {
        Allure.step("Видимость валидационного сообщения \"Сохранение не удалось. Попробуйте позднее.\"");
        checkToast(getErrorSavingNews(), true);
    }

    public void checkSelectCategoryToast() {
        Allure.step("Видимость валидационного сообщения \"Выберите категорию\"");
        checkToast(getSelectCategoryError(), true);
    }
}
