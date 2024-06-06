package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.ViewActions.elementWaiting;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.LoginCredentials;
import ru.iteco.fmhandroid.ui.elements.AuthPageElements;

public class AuthPage {

    AuthPageElements authPageElements = new AuthPageElements();

    public void loadAuthPage() {
        Allure.step("Загрузка страницы авторизации");
        elementWaiting(withId(R.id.enter_button), 2000);
    }

    public void checkAuthPage() {
        Allure.step("Проверка отображения элементов страницы аутентификации");
        authPageElements.auth.check(matches(isDisplayed()));
    }

    public void loginValidCredentials(LoginCredentials.User validCredentials) {
        Allure.step("Аутентификация с валидными данными");
        authPageElements.loginField.perform(replaceText(validCredentials.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(validCredentials.getLogin())));
        authPageElements.passwordField.perform(replaceText(validCredentials.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(validCredentials.getPassword())));
    }

    public void invalidCredentials(LoginCredentials.User invalidCredentials) {
        Allure.step("Аутентификация с невалидными данными");
        authPageElements.loginField.perform(replaceText(invalidCredentials.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(invalidCredentials.getLogin())));
        authPageElements.passwordField.perform(replaceText(invalidCredentials.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(invalidCredentials.getPassword())));
    }

    public void invalidLogin(LoginCredentials.User invalidLogin) {
        Allure.step("Аутентификация с невалидным логином и валидным паролем");
        authPageElements.loginField.perform(replaceText(invalidLogin.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(invalidLogin.getLogin())));
        authPageElements.passwordField.perform(replaceText(invalidLogin.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(invalidLogin.getPassword())));
    }

    public void invalidPassword(LoginCredentials.User invalidPassword) {
        Allure.step("Аутентификация с валидным логином и невалидным паролем");
        authPageElements.loginField.perform(replaceText(invalidPassword.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(invalidPassword.getLogin())));
        authPageElements.passwordField.perform(replaceText(invalidPassword.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(invalidPassword.getPassword())));
    }

    public void emptyLogin(LoginCredentials.User emptyLogin) {
        Allure.step("Аутентификация с пустым полем логина и валидным паролем");
        authPageElements.loginField.perform(replaceText(emptyLogin.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(emptyLogin.getLogin())));
        authPageElements.passwordField.perform(replaceText(emptyLogin.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(emptyLogin.getPassword())));
    }

    public void emptyPassword(LoginCredentials.User emptyPassword) {
        Allure.step("Аутентификация с валидным логином и пустым полем пароля");
        authPageElements.loginField.perform(replaceText(emptyPassword.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(emptyPassword.getLogin())));
        authPageElements.passwordField.perform(replaceText(emptyPassword.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(emptyPassword.getPassword())));
    }

    public void sqlInjectionLogin(LoginCredentials.User sqlLogin) {
        Allure.step("Введение SQL-инъекции в поле логина и валидного пароля");
        authPageElements.loginField.perform(replaceText(sqlLogin.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(sqlLogin.getLogin())));
        authPageElements.passwordField.perform(replaceText(sqlLogin.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(sqlLogin.getPassword())));
    }

    public void maxLengthLogin(LoginCredentials.User maxLengthLogin) {
        Allure.step("Аутентификация с максимально длинным логином и валидным паролем");
        authPageElements.loginField.perform(replaceText(maxLengthLogin.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(maxLengthLogin.getLogin())));
        authPageElements.passwordField.perform(replaceText(maxLengthLogin.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(maxLengthLogin.getPassword())));
    }

    public void minLengthPassword(LoginCredentials.User minLengthPassword) {
        Allure.step("Аутентификация с валидным логином и паролем минимальной длины");
        authPageElements.loginField.perform(replaceText(minLengthPassword.getLogin()), closeSoftKeyboard());
        authPageElements.loginField.check(matches(withText(minLengthPassword.getLogin())));
        authPageElements.passwordField.perform(replaceText(minLengthPassword.getPassword()), closeSoftKeyboard());
        authPageElements.passwordField.check(matches(withText(minLengthPassword.getPassword())));
    }

    public void clickSignInButton() {
        Allure.step("Нажать на кнопку \"Войти\"");
        authPageElements.signInButton.perform(click());
    }
}