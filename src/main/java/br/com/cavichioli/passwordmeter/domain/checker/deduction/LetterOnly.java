package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.checker.DeductionChecker;

public class LetterOnly extends DeductionChecker {

    private LetterOnly(Password password) {
        super(password);
    }

    public static LetterOnly of(Password password) {
        return new LetterOnly(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()){
            String letters = password.getValue().replaceAll("[^A-Za-z]", "");
            if (letters.length() == password.getLength()) {
                return Score.of(letters.length());
            }
        }
        return Score.ZERO;
    }

}
