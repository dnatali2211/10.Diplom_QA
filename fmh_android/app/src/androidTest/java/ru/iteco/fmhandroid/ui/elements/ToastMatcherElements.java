package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.ViewActions;

public class ToastMatcherElements {
    public ViewInteraction toastMatcher(int id) {
        return onView(withText(id)).inRoot(new ViewActions.ToastMatcher());
    }

    public static int getFieldsCanNotBeEmpty() {
        return R.string.empty_login_or_password;
    }

    public static int getFillEmptyFields() {
        return R.string.empty_fields;
    }

    public static int getWrongLoginOrPassword() {
        return R.string.wrong_login_or_password;
    }

    public static int getErrorSavingNews() {
        return R.string.error_saving;
    }

    public static int getSelectCategoryError() {
        return R.string.select_category;
    }

    public static int getSomethingWentWrong() {
        return R.string.error;
    }
}
