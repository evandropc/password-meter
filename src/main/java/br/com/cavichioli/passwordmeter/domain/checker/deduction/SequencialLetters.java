package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.checker.DeductionChecker;
import br.com.cavichioli.passwordmeter.domain.checker.sequencialchars.ListThreeSequencialChars;
import br.com.cavichioli.passwordmeter.domain.Score.Score;

public class SequencialLetters extends DeductionChecker {

    private SequencialLetters(Password password) {
        super(password);
    }

    public static SequencialLetters of(Password password) {
        return new SequencialLetters(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Score.of(ListThreeSequencialChars.alphas(password.getValue())
                    .getSequencials().size() * 3);
        }
        return Score.ZERO;
    }

}
