package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class NewsPageElements {

    // Кнопка сортировки новостей
    public ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));

    // Кнопка фильтрации новостей
    public ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));

    // Кнопка редактирования новостей
    public ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));

    // Блок со списком всех новостей
    public ViewInteraction allNewsBlock = onView(withId(R.id.all_news_cards_block_constraint_layout));

    public static Matcher<View> getNewsTitleText() {
        return ViewMatchers.withId(R.id.news_item_title_text_view);
    }

    public static Matcher<View> getNewsMainList() {
        return ViewMatchers.withId(R.id.news_list_recycler_view);
    }

    public static Matcher<View> getDescriptionTextNewsView() {
        return ViewMatchers.withId(R.id.news_item_description_text_view);
    }
}

