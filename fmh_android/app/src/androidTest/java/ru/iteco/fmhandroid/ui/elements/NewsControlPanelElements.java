package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.ViewActions.childAtPosition;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class NewsControlPanelElements {

    //    Выбранный блок с одной новостью
    public ViewInteraction oneNewsBlockPanel = onView(
            allOf(withId(R.id.news_list_recycler_view),
                    childAtPosition(
                            withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                            0)));

    //    Сообщение об удалении новости в модальном окне
    public ViewInteraction messageAboutDelete = onView(
            allOf(withId(android.R.id.message), withText("Вы уверены, что хотите безвозвратно удалить документ? Данные изменения нельзя будет отменить в будущем."),
                    withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class)))));

    //     Кнопка создания новости
    public ViewInteraction createNewsButton = onView(withId(R.id.add_news_image_view));

    //    Кнопка удаления новости
    public ViewInteraction deleteNewsButton = onView(withId(R.id.delete_news_item_image_view));

    // Кнопка редактирования новости
    public ViewInteraction editNewsButton = onView(withId(R.id.edit_news_item_image_view));

    //    Статус новости активна/не активна
    public ViewInteraction newsStatusButton = onView(withId(R.id.news_item_published_text_view));

    public static Matcher<View> getButtonEditNews() {
        return ViewMatchers.withId(R.id.edit_news_item_image_view);
    }

    public static Matcher<View> getButtonDeleteNews() {
        return ViewMatchers.withId(R.id.delete_news_item_image_view);
    }
}
