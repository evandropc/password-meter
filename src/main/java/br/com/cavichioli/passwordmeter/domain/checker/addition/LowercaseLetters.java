package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.checker.AdditionChecker;
import br.com.cavichioli.passwordmeter.domain.Score.Score;

public class LowercaseLetters extends AdditionChecker {

    private LowercaseLetters(Password password) {
        super(password);
    }

    public static LowercaseLetters of(Password password) {
        return new LowercaseLetters(password);
    }

    @Override
    protected Score calculateScore() {
        final String lower = filterOnlyLowerCase(password.getValue());
        if (lower.length() > 0) {
            return Score.of((password.getLength() - lower.length()) * 2);
        }
        return Score.ZERO;
    }

    public static String filterOnlyLowerCase(String value) {
        return value.replaceAll("[^a-z]", "");
    }

}
