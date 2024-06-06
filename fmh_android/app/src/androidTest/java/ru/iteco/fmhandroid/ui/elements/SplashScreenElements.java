package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class SplashScreenElements {

    //    Изображение на экране загрузки
    public ViewInteraction imageSplashScreen = onView(withId(R.id.splashscreen_image_view));

    //    Кружок "Download"
    public ViewInteraction progressIndicator = onView(withId(R.id.splash_screen_circular_progress_indicator));

    //    Текст на экране загрузки
    public ViewInteraction splashScreenText = onView(withId(R.id.splashscreen_text_view));

    public static Matcher<View> getSplashScreenImage() {
        return ViewMatchers.withId(R.id.splashscreen_image_view);
    }

}
