package ru.iteco.fmhandroid.ui.steps;

import static ru.iteco.fmhandroid.ui.data.ViewActions.elementWaiting;
import static ru.iteco.fmhandroid.ui.elements.SplashScreenElements.getSplashScreenImage;

import io.qameta.allure.kotlin.Allure;

public class SplashScreenPage {
    public void appDownloading() {
        Allure.step("Загрузка приложения");
        elementWaiting(getSplashScreenImage(), 2000);
    }
}
