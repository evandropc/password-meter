package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.checker.AdditionChecker;
import br.com.cavichioli.passwordmeter.domain.password.Password;

public class NumberOfCharacters extends AdditionChecker {

    private NumberOfCharacters(Password password) {
        super(password);
    }

    public static NumberOfCharacters of(Password password) {
        return new NumberOfCharacters(password);
    }

    @Override
    protected Score calculateScore() {
        return Score.of(password.getLength() * 4);
    }

}
