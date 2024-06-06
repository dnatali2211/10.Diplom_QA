package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class AboutAppElements {

    // Текст "Версия:"
    public ViewInteraction versionAppText = onView(withId(R.id.about_version_title_text_view));

    // Номер версии приложения
    public ViewInteraction versionAppValue = onView(withId(R.id.about_version_value_text_view));

    //    Текст "Политика конфиденциальности"
    public ViewInteraction privacyPolicyTitle =
            onView(withId(R.id.about_privacy_policy_label_text_view));

    //    Ссылка на политику конфиденциальности
    public ViewInteraction privacyPolicyLink =
            onView(withId(R.id.about_privacy_policy_value_text_view));

    //   Текст "Пользовательское соглашение"
    public ViewInteraction termsOfUseTitle =
            onView(withId(R.id.about_terms_of_use_label_text_view));

    //   Ссылка на пользовательское соглашение
    public ViewInteraction termsOfUseLink =
            onView(withId(R.id.about_terms_of_use_value_text_view));

    //   Логотип компании
    public ViewInteraction companyLabel =
            onView(withId(R.id.about_company_info_label_text_view));

    //    Кнопка "Назад"
    public ViewInteraction returnButton = onView(withId(R.id.about_back_image_button));
}