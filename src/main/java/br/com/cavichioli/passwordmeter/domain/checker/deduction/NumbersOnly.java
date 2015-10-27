package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.checker.addition.Numbers;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.checker.DeductionChecker;

public class NumbersOnly extends DeductionChecker {

    private NumbersOnly(Password password) {
        super(password);
    }

    public static NumbersOnly of(Password password) {
        return new NumbersOnly(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()){
            String numbers = Numbers.filterOnlyNumbers(password.getValue());
            if (numbers.length() == password.getLength()) {
                return Score.of(numbers.length());
            }
        }
        return Score.ZERO;
    }

}
