package ru.iteco.fmhandroid.ui.data;

import com.github.javafaker.Faker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NewsData {

    public static final String advertisement = "Объявление";
    public static final String birthday = "День рождения";
    public static final String salary = "Зарплата";
    public static final String union = "Профсоюз";
    public static final String holiday = "Праздник";
    public static final String massage = "Массаж";
    public static final String gratitude = "Благодарность";
    public static final String help = "Нужна помощь";

    public String xssToCategory = "<script>alert('XSS');</script";
    public String sqlToCategory = "' OR '1'='1";
    public String wrongCategory = "Жалоба";
    public String emptyCategory = "";
    public String randomTitle = generateRandomTitle();
    public String ruTitle = "Заголовок 1";
    public String arabicTitle = "أخبار";
    public String publicDate = getCurrentDate();
    public String publicDateInPast = "12.08.2000";
    public String publicTime = getCurrentTime();
    public String wrongHours = "27";
    public String wrongMinutes = "94";
    public String validHours = getCurrentHours();
    public String validMinutes = getCurrentMinutes();
    public String randomDescription = generateRandomDescription();
    public String editDescriptionText = "Измененный текст описания";
    public String ruDescription = "Описание 1";
    public static final Faker faker = new Faker();

    public static String generateRandomTitle() {
        return faker.book().title();
    }

    public static String generateRandomDescription() {
        return faker.lorem().sentence();
    }

    public static String getCurrentDate() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    public static String getCurrentTime() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    public static String getCurrentHours() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH", Locale.getDefault());
        return dateFormat.format(currentDate);
    }

    public static String getCurrentMinutes() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("mm", Locale.getDefault());
        return dateFormat.format(currentDate);
    }
}