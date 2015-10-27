package br.com.cavichioli.passwordmeter.domain.checker;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.password.Password;

public abstract class DeductionChecker extends AbstractChecker {

    protected DeductionChecker(Password password) {
        super(password);
    }

    @Override
    protected Score calculateScore() {
        return calculate().negative();
    }

    protected abstract Score calculate();

}
