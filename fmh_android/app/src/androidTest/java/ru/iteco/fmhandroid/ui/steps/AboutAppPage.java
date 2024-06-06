package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AboutAppElements;
import ru.iteco.fmhandroid.ui.elements.MainPageElements;

public class AboutAppPage {
    MainPageElements mainPageElements = new MainPageElements();
    AboutAppElements aboutAppElements = new AboutAppElements();

    public void checkScreenElementsAbout() {
        Allure.step("Проверка элементов страницы \"О приложении\"");
        mainPageElements.tradeMarkVHospise.check(matches(isDisplayed()));
        aboutAppElements.versionAppText.check(matches(isDisplayed()));
        aboutAppElements.versionAppValue.check(matches(isDisplayed()));
        aboutAppElements.privacyPolicyTitle.check(matches(isDisplayed()));
        aboutAppElements.privacyPolicyLink.check(matches(isDisplayed()));
        aboutAppElements.termsOfUseTitle.check(matches(isDisplayed()));
        aboutAppElements.termsOfUseLink.check(matches(isDisplayed()));
        aboutAppElements.companyLabel.check(matches(isDisplayed()));
        aboutAppElements.returnButton.check(matches(isDisplayed()));
    }

    public void clickPrivacyPolicyLink() {
        Allure.step("Клик по ссылке \"Политика конфиденциальности\"");
        aboutAppElements.privacyPolicyLink.perform(click());
    }

    public void clickTermsOfUseLink() {
        Allure.step("Клик по ссылке \"Пользовательское соглашение\"");
        aboutAppElements.termsOfUseLink.perform(click());
    }

    public void clickReturnButton() {
        Allure.step("Нажать кнопку \"Назад\"");
        aboutAppElements.returnButton.perform(click());
    }
}