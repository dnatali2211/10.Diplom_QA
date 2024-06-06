package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.ViewActions.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPageElements {

    //    Логотип "ВХОСПИСЕ"
    public ViewInteraction tradeMarkVHospise = onView(withId(R.id.trademark_image_view));

    // Кнопка личного кабинета
    public ViewInteraction accountButton = onView(withId(R.id.authorization_image_button));

    //    Кнопка выхода из личного кабинета
    public ViewInteraction logOutButton = onView(allOf(withId(android.R.id.title), withText("Выйти")));

    // Заголовок "Новости"
    public ViewInteraction checkTitleNews = onView(withText("Новости"));

    //    Кнопка-стрелка скрыть/раскрыть список всех новостей
    public ViewInteraction hideExpandAllNewsButton = onView(
            allOf(withId(R.id.expand_material_button),
                    childAtPosition(withClassName(is("android.widget.LinearLayout")),
                            childAtPosition(withClassName(is("android.widget.LinearLayout")),
                                    withId(R.id.container_list_news_include_on_fragment_main),
                                    0), 4)));

    //    Кнопка "ВСК НОВОСТИ"
    public ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));

    //    Выбранный блок с одной новостью
    public ViewInteraction oneNewsBlockMainPage = onView(allOf(withId(R.id.news_list_recycler_view),
            childAtPosition(withId(R.id.all_news_cards_block_constraint_layout), 0)));

    //    Кнопка-гамбургер
    public ViewInteraction hamburgerButton = onView(withId(R.id.main_menu_image_button));

    //    Кнопка перехода на главную страницу
    public ViewInteraction mainPageButton = onView(allOf(withId(android.R.id.title), withText("Главная")));

    //    Кнопка перехода на страницу "Новости"
    public ViewInteraction newsPageButton = onView(allOf(withId(android.R.id.title), withText("Новости")));

    //    Кнопка перехода на страницу "О приложении"
    public ViewInteraction aboutOfApp = onView(allOf(withId(android.R.id.title), withText("О приложении")));

    // Кнопка перехода на страницу "Наша миссия"
    public ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));
}
