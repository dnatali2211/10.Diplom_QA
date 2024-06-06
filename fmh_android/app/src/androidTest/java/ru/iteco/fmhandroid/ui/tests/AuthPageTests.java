package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.LoginCredentials.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.emptyPassword;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.invalidCredentials;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.invalidPassword;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.maxLengthLogin;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.minLengthPassword;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.sqlLogin;
import static ru.iteco.fmhandroid.ui.data.LoginCredentials.validCredentials;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.elements.AuthPageElements;
import ru.iteco.fmhandroid.ui.steps.AuthPage;
import ru.iteco.fmhandroid.ui.steps.MainPage;
import ru.iteco.fmhandroid.ui.steps.SplashScreenPage;
import ru.iteco.fmhandroid.ui.steps.ToastMatcherSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AuthPageTests {
    AuthPage authPage = new AuthPage();
    MainPage mainPage = new MainPage();
    ToastMatcherSteps toastMatcherSteps = new ToastMatcherSteps();
    SplashScreenPage splashScreenPage = new SplashScreenPage();

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void logoutCheck() {
        splashScreenPage.appDownloading();
        try {
            authPage.loadAuthPage();
            authPage.checkAuthPage();
        } catch (Exception e) {
            mainPage.logOut();
            authPage.loadAuthPage();
        }
    }

    @Test
    @DisplayName("Отображение всех элементов формы аутентификации")
    @Description("Элементы формы аутентификации отображены на странице")
    public void testCheckAuthScreenElements() {
        authPage.checkAuthPage();
    }

    @Test
    @DisplayName("Аутентификация с валидными данными")
    @Description("Пользователь может успешно аутентифицироваться с использованием правильного комбинированного логина и пароля")
    public void testLoginWithValidCredentials() {
        authPage.loginValidCredentials(validCredentials());
        authPage.clickSignInButton();
        mainPage.mainPageLoad();
    }

    @Test
//    Негативный тест
    @DisplayName("Аутентификация с невалидным логином и валидным паролем")
    @Description("При попытке входа в систему с невалидным логином и валидным паролем отклоняются, и пользователь получает соответствующее сообщение об ошибке")
    public void failedTestLoginWithInvalidLogin() {
        authPage.invalidLogin(invalidLogin());
        authPage.clickSignInButton();
        toastMatcherSteps.checkWrongLoginOrPasswordToast();
    }

    @Test
//    Негативный тест
    @DisplayName("Аутентификация с валидным логином и невалидным паролем")
    @Description("При попытке входа в систему с валидным логином и невалидным паролем отклоняются, и пользователь получает соответствующее сообщение об ошибке")
    public void failedTestLoginWithInvalidPassword() {
        authPage.invalidPassword(invalidPassword());
        authPage.clickSignInButton();
        toastMatcherSteps.checkWrongLoginOrPasswordToast();
    }

    @Test
//    Негативный тест
    @DisplayName("Аутентификация с невалидными логином и паролем")
    @Description("При попытке входа в систему с невалидными логином и паролем отклоняются, и пользователь получает соответствующее сообщение об ошибке")
    public void failedTestLoginWithInvalidCredentials() {
        authPage.invalidCredentials(invalidCredentials());
        authPage.clickSignInButton();
        toastMatcherSteps.checkWrongLoginOrPasswordToast();
    }

    @Test
//    Негативный тест
    @DisplayName("Аутентификация с пустыми полями логина и пароля")
    @Description("Неуспешная попытка входа в систему с использованием пустых полей логина и пароля")
    public void testLoginWithEmptyFields() {
        authPage.clickSignInButton();
        toastMatcherSteps.checkFieldsCanNotBeEmptyToast();
    }

    @Test
    //    Негативный тест
    @DisplayName("Аутентификация с пустым полем логина и валидным паролем")
    @Description("При попытке входа в систему с пустым полем логина и валидным паролем отклоняются, и пользователь получает соответствующее сообщение об ошибке")
    public void testLoginWithEmptyLogin() {
        authPage.emptyLogin(emptyLogin());
        authPage.clickSignInButton();
        toastMatcherSteps.checkFieldsCanNotBeEmptyToast();
    }

    @Test
    //    Негативный тест
    @DisplayName("Аутентификация с валидным логином и пустым полем пароля")
    @Description("При попытке входа в систему с валидным логином и пустым полем пароля отклоняются, и пользователь получает соответствующее сообщение об ошибке")
    public void testLoginWithEmptyPassword() {
        authPage.emptyPassword(emptyPassword());
        authPage.clickSignInButton();
        toastMatcherSteps.checkFieldsCanNotBeEmptyToast();
    }

    @Test
    //    Негативный тест
    @DisplayName("Аутентификация с использованием SQL-инъекции в поле логина")
    @Description("При вводе SQl-инъекции в поле логина приложение устойчиво и пользователь получает соответствующее сообщение об ошибке")
    public void testLoginWithSQLInjection() {
        authPage.sqlInjectionLogin(sqlLogin());
        authPage.clickSignInButton();
        toastMatcherSteps.checkSomethingWentWrongToast();
    }

    @Test
    //    Негативный тест
    @DisplayName("Аутентификация с логином максимальной длины и валидным паролем")
    @Description("При вводе максимально длинного логина попытка входа в систему отклоняется и пользователь получает соответствующее сообщение об ошибке")
    public void testLoginWithMaxLengthCredentials() {
        authPage.maxLengthLogin(maxLengthLogin());
        authPage.clickSignInButton();
        toastMatcherSteps.checkSomethingWentWrongToast();
    }

    @Test
//    Негативный тест
    @DisplayName("Аутентификация с валидным логином и паролем минимальной длины")
    @Description("При вводе пароля минимальной длины попытка входа в систему отклоняется и пользователь получает соответствующее сообщение об ошибке")
    public void testLoginWithShortPassword() {
        authPage.minLengthPassword(minLengthPassword());
        authPage.clickSignInButton();
        toastMatcherSteps.checkSomethingWentWrongToast();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Сессии аутентификации устанавливаются и удаляются корректно при входе в систему и выходе из нее")
    public void testAccountLogout() {
        authPage.loginValidCredentials(validCredentials());
        authPage.clickSignInButton();
        mainPage.mainPageLoad();
        mainPage.logOut();
        authPage.checkAuthPage();
    }
}
