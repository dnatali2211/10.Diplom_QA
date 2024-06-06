package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import static ru.iteco.fmhandroid.ui.data.ViewActions.childAtPosition;

import androidx.test.espresso.contrib.RecyclerViewActions;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.OurMissionPageElements;


public class OurMissionPage {
    OurMissionPageElements ourMissionPageElements = new OurMissionPageElements();

    public void viewOurMissionPageElements() {
        Allure.step("Отображение элементов страницы c цитатами");
        ourMissionPageElements.missionNewsPageTitle.check(matches(isDisplayed()));
        ourMissionPageElements.quotesList.check(matches(isDisplayed()));
        ourMissionPageElements.quoteBlock.check(matches(isDisplayed()));
    }

    public void hideExpendQuote(int index) {
        Allure.step("Развернуть/свернуть цитату");
        ourMissionPageElements.quoteBlock.check(matches(isDisplayed()));
        ourMissionPageElements.quoteBlock.perform(actionOnItemAtPosition(index, click()));
    }

    public void toggleQuoteDescriptionDisplay(String text, boolean shouldBeDisplayed) {
        Allure.step(shouldBeDisplayed ? "Отображение цитаты" : "Cкрытие цитаты");
        onView(allOf(ourMissionPageElements.getQuoteDescriptionText(), withText(text)))
                .check(matches(shouldBeDisplayed ? isDisplayed() : not(isDisplayed())));
    }

    public void scrollToChoosenQuote(int position) {
        Allure.step("Скрол до необходимой цитаты");
        onView(allOf(withId(R.id.our_mission_item_list_recycler_view),
                childAtPosition(withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                        0))).perform(RecyclerViewActions.scrollToPosition(position));
    }
}
