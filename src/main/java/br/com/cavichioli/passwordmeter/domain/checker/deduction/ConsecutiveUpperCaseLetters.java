package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.checker.DeductionChecker;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.Score.Score;

import java.util.stream.Stream;

public class ConsecutiveUpperCaseLetters extends DeductionChecker {

    private ConsecutiveUpperCaseLetters(Password password) {
        super(password);
    }

    public static ConsecutiveUpperCaseLetters of(Password password) {
        return new ConsecutiveUpperCaseLetters(password);
    }

    @Override
    protected Score calculate() {
        if (!password.isEmpty()) {
            return Stream.of(password.getValue().replaceAll("[^A-Z]", ";").split(";"))
                    .filter(s -> s.length() > 1)
                    .map(s -> s.length() - 1)
                    .map(n -> Score.of(n * 2))
                    .reduce(Score.ZERO, Score::sum);
        }
        return Score.ZERO;
    }

}
