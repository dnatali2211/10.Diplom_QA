package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.ViewActions.childAtPosition;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class CreateAndEditElements {

    //    Название страницы "Создание"
    public ViewInteraction creatingNewsPageTitle = onView(allOf(withId(R.id.custom_app_bar_title_text_view), withText("Создание")));

    //    Название страницы "Редактирование"
    public ViewInteraction editingNewsPageTitle = onView(allOf(withId(R.id.custom_app_bar_title_text_view), withText("Редактирование")));

    //    Поле "Категория"
    public ViewInteraction categoryField =
            onView(withId(R.id.news_item_category_text_auto_complete_text_view));

    //    Поле "Заголовок"
    public ViewInteraction titleField = onView(withId(R.id.news_item_title_text_input_edit_text));

    //    Поле "Дата публикации"
    public ViewInteraction publicationDateField =
            onView(withId(R.id.news_item_publish_date_text_input_edit_text));

    //    Поле "Время публикации"
    public ViewInteraction publicationTimeField =
            onView(withId(R.id.news_item_publish_time_text_input_edit_text));

    //    Поле "Описание"
    public ViewInteraction descriptionField =
            onView(withId(R.id.news_item_description_text_input_edit_text));

    //    Переключатель статуса новости
    public ViewInteraction statusSwitcher = onView(withId(R.id.switcher));

    //    Кнопка "СОХРАНИТЬ"
    public ViewInteraction saveButton = onView(withId(R.id.save_button));

    //    Кнопка "ОТМЕНА"
    public ViewInteraction cancelButton = onView(withId(R.id.cancel_button));

    //    Кнопка "ОК" в модальном окне
    public ViewInteraction okButton = onView(withId(android.R.id.button1));

    // Кнопка "ОТМЕНА" в модальном окне
    public ViewInteraction miniCancelButton = onView(withId(android.R.id.button2));

    // Уведомление о недопустимом времени в модальном окне
    public ViewInteraction wrongTimeError = onView(
            allOf(IsInstanceOf.<View>instanceOf(android.widget.TextView.class), withText("Указано недопустимое время."),
                    withParent(allOf(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                            withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class))))));

    //    Уведомление об отмене сохранения изменений в модальном окне
    public ViewInteraction cancelChangesNewsMessage = onView(
            allOf(withId(android.R.id.message), withText("Изменения не будут сохранены. Вы действительно хотите выйти?"),
                    withParent(withParent(withId(com.google.android.material.R.id.scrollView)))));

    //    Кнопка для введения времени через клавиатуру в модальном окне "Время"
    public ViewInteraction buttonKeyboardForTime = onView(
            allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")), withContentDescription("Чтобы ввести время, перейдите в режим ввода текста."),
                    childAtPosition(
                            childAtPosition(
                                    withClassName(is("android.widget.LinearLayout")),
                                    4),
                            0)));

    //    Поле "ч." в модальном окне "Время"
    public ViewInteraction hoursField = onView(
            allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                    childAtPosition(
                            allOf(withClassName(is("android.widget.RelativeLayout")),
                                    childAtPosition(
                                            withClassName(is("android.widget.TextInputTimePickerView")),
                                            1)),
                            0)));

    // Поле "мин." в модальном окне "Время"
    public ViewInteraction minutesField = onView(
            allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                    childAtPosition(
                            allOf(withClassName(is("android.widget.RelativeLayout")),
                                    childAtPosition(
                                            withClassName(is("android.widget.TextInputTimePickerView")),
                                            1)),
                            3)));
}
