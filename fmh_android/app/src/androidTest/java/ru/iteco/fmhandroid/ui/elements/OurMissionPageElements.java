package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.ViewActions.childAtPosition;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;


public class OurMissionPageElements {

    //    Название страницы "Главное - жить любя"
    public ViewInteraction missionNewsPageTitle = onView((withId(R.id.our_mission_title_text_view)));

    //    Список всех цитат
    public ViewInteraction quotesList = onView(withId(R.id.our_mission_item_list_recycler_view));

    //    Отдельный блок с цитатой
    public ViewInteraction quoteBlock = onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
            childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")), 0)));

    //   Текст описания цитаты
    public Matcher<View> getQuoteDescriptionText() {
        return ViewMatchers.withId(R.id.our_mission_item_description_text_view);
    }
}
