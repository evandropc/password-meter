package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.checker.DeductionChecker;
import br.com.cavichioli.passwordmeter.domain.checker.sequencialchars.ListThreeSequencialChars;

public class SequencialSymbols extends DeductionChecker {

    private SequencialSymbols(Password password) {
        super(password);
    }

    public static SequencialSymbols of(Password password) {
        return new SequencialSymbols(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Score.of(ListThreeSequencialChars.symbols(password.getValue())
                    .getSequencials().size() * 3);
        }
        return Score.ZERO;
    }

}
