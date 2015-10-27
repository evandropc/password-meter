package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.checker.DeductionChecker;
import br.com.cavichioli.passwordmeter.domain.checker.sequencialchars.ListThreeSequencialChars;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.Score.Score;

public class SequencialNumbers extends DeductionChecker {

    private SequencialNumbers(Password password) {
        super(password);
    }

    public static SequencialNumbers of(Password password) {
        return new SequencialNumbers(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Score.of(ListThreeSequencialChars.numbers(password.getValue())
                    .getSequencials().size() * 3);
        }
        return Score.ZERO;
    }

}
