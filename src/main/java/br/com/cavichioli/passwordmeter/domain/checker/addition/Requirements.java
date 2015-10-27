package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.checker.AdditionChecker;
import br.com.cavichioli.passwordmeter.domain.Score.Score;

public class Requirements extends AdditionChecker {

    private Requirements(Password password) {
        super(password);
    }

    public static Requirements of(Password password) {
        return new Requirements(password);
    }

    @Override
    protected Score calculateScore() {
        int requirement = 0;
        int minRequirementChars = 4;
        if(UppercaseLetters.filterOnlyUpperCases(password.getValue()).length() >= 1){
            requirement++;
        }
        if(LowercaseLetters.filterOnlyLowerCase(password.getValue()).length() >= 1){
            requirement++;
        }
        if(Numbers.filterOnlyNumbers(password.getValue()).length() >= 1){
            requirement++;
        }
        if(Symbols.filterOnlySymbols(password.getValue()).length() >= 1){
            requirement++;
        }
        if (password.getLength() >= 8) {
            requirement++;
            minRequirementChars = 3;
        }
        if (requirement > minRequirementChars) {
            return Score.of(requirement * 2);
        }
        return Score.ZERO;
    }

}
