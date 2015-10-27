package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.checker.AdditionChecker;
import br.com.cavichioli.passwordmeter.domain.password.Password;

public class UppercaseLetters extends AdditionChecker {

    private UppercaseLetters(Password password) {
        super(password);
    }

    public static UppercaseLetters of(Password password) {
        return new UppercaseLetters(password);
    }

    @Override
    protected Score calculateScore() {
        final String upper = filterOnlyUpperCases(password.getValue());
        if (upper.length() > 0) {
            return Score.of((password.getLength() - upper.length()) * 2);
        }
        return Score.ZERO;
    }

    public static String filterOnlyUpperCases(String value) {
        return value.replaceAll("[^A-Z]", "");
    }

}
