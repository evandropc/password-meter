package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.checker.AdditionChecker;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.Score.Score;

public class Numbers extends AdditionChecker {

    private Numbers(Password password) {
        super(password);
    }

    public static Numbers of(Password password) {
        return new Numbers(password);
    }

    @Override
    protected Score calculateScore() {
        final String numbers = filterOnlyNumbers(password.getValue());
        if (numbers.length() != password.getLength()) {
            return Score.of((numbers.length()) * 4);
        }
        return Score.ZERO;
    }

    public static String filterOnlyNumbers(String value) {
        return value.replaceAll("[^0-9]", "");
    }

}
