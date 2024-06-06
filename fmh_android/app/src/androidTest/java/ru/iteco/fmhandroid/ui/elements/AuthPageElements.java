package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AuthPageElements {

    //    Название страницы "Авторизация"
    public ViewInteraction auth = onView(withText(R.string.authorization));

    //    Поле "Логин"
    public ViewInteraction loginField = onView(withHint(R.string.login));

    //    Поле "Пароль"
    public ViewInteraction passwordField = onView(withHint(R.string.password));

    //    Кнопка "ВОЙТИ"
    public ViewInteraction signInButton = onView(withId(R.id.enter_button));
}