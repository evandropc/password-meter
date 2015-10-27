package br.com.cavichioli.passwordmeter.domain.password;

public class PasswordDataProvider {

    public static Password EMPTY = Password.of("");

    public static Password ONE_CARACTER = Password.of("a");

    public static Password ONE_NUMBER = Password.of("1");

    public static Password ONE_SYMBOL = Password.of("@");

    public static Password EIGHT_NUMBERS = Password.of("12345678");

    public static Password EIGHT_SYMBOLS = Password.of("!@#$%*()");

    public static Password EIGHT_CARACT_NUM = Password.of("s2d3f4g5");

    public static Password EIGHT_CARACT_NUM_SYMB = Password.of("A2@3#$g8");

    public static Password EXCEPTIONAL = Password.of("aB@7nG&1q");

}
