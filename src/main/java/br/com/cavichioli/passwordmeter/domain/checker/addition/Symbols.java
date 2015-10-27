package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.checker.AdditionChecker;
import br.com.cavichioli.passwordmeter.domain.password.Password;

public class Symbols extends AdditionChecker {

    private Symbols(Password password) {
        super(password);
    }

    public static Symbols of(Password password) {
        return new Symbols(password);
    }

    @Override
    protected Score calculateScore() {
        return Score.of((filterOnlySymbols(password.getValue()).length()) * 6);
    }

    public static String filterOnlySymbols(String value) {
        return value.replaceAll("[\\w\\d]", "");
    }

}
