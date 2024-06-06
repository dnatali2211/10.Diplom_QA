package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class FilterNewsElements {

    //   Название страницы "Фильтровать новости"
    public ViewInteraction filterNewsPageTitle = onView(withId(R.id.filter_news_title_text_view));

    //    Поле "Категория"
    public ViewInteraction categoryField =
            onView(withId(R.id.news_item_category_text_auto_complete_text_view));

    // Дата фильтрации "с"
    public ViewInteraction filterStartDateField = onView(withId(R.id.news_item_publish_date_start_text_input_edit_text));

    //    Дата фильтрации "по"
    public ViewInteraction filterEndDateField = onView(withId(R.id.news_item_publish_date_end_text_input_edit_text));

    //   Кнопка "Фильтровать"
    public ViewInteraction filterButton = onView(withId(R.id.filter_button));
}
