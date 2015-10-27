package br.com.cavichioli.passwordmeter.domain.checker;

import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.Score.Score;

public abstract class AdditionChecker extends AbstractChecker {

    protected AdditionChecker(Password password) {
        super(password);
    }

    protected abstract Score calculateScore();

}
