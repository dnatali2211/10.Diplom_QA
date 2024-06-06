package ru.iteco.fmhandroid.ui.data;

public class LoginCredentials {
    public LoginCredentials() {
    }

    public static class User {
        private final String login;
        private final String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    private static final String validLogin = "login2";
    private static final String validPassword = "password2";
    private static final String invalidLogin = "wronglogin123";
    private static final String invalidPassword = "wrongpassword123";
    private static final String emptyLogin = "";
    private static final String emptyPassword = "";
    private static final String sqlLogin = "admin' OR 1=1 --";
    private static final String maxLengthLogin = new String(new char[255]).replace('\0', 'a');
    private static final String minLengthPassword = new String("1");


    public static User validCredentials() {

        return new User(validLogin, validPassword);
    }

    public static User invalidCredentials() {
        return new User(invalidLogin, invalidPassword);
    }

    public static User invalidLogin() {
        return new User(invalidLogin, validPassword);
    }

    public static User invalidPassword() {
        return new User(validLogin, invalidPassword);
    }

    public static User emptyLogin() {
        return new User(emptyLogin, validPassword);
    }

    public static User emptyPassword() {
        return new User(validLogin, emptyPassword);
    }

    public static User sqlLogin() {
        return new User(sqlLogin, validPassword);
    }

    public static User maxLengthLogin() {
        return new User(maxLengthLogin, validPassword);
    }

    public static User minLengthPassword() {
        return new User(validLogin, minLengthPassword);
    }
}
