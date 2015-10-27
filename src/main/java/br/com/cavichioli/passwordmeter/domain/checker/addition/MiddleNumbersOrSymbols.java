package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.checker.AdditionChecker;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.Score.Score;

public class MiddleNumbersOrSymbols extends AdditionChecker {

    private MiddleNumbersOrSymbols(Password password) {
        super(password);
    }

    public static MiddleNumbersOrSymbols of(Password password) {
        return new MiddleNumbersOrSymbols(password);
    }

    @Override
    protected Score calculateScore() {
        if (password.getLength() > 2) {
            String middle = password.getValue().substring(1, password.getLength() - 1);
            String simbolsOrNumbers = middle.replaceAll("[^\\W\\d]", "");
            return Score.of((simbolsOrNumbers.length()) * 2);
        }
        return Score.ZERO;
    }

}
