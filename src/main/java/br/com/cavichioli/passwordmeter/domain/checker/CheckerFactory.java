package br.com.cavichioli.passwordmeter.domain.checker;

import br.com.cavichioli.passwordmeter.domain.checker.addition.*;
import br.com.cavichioli.passwordmeter.domain.checker.deduction.*;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class CheckerFactory {

    public static List<Checker> of(Password password) {
        checkNotNull(password, "password não pode ser null");
        ImmutableList.Builder<Checker> builder = ImmutableList.builder();

        builder.add(NumberOfCharacters.of(password));
        builder.add(UppercaseLetters.of(password));
        builder.add(LowercaseLetters.of(password));
        builder.add(Numbers.of(password));
        builder.add(Symbols.of(password));
        builder.add(MiddleNumbersOrSymbols.of(password));
        builder.add(Requirements.of(password));

        builder.add(LetterOnly.of(password));
        builder.add(NumbersOnly.of(password));
        builder.add(RepeatCharactersCaseInsensitive.of(password));
        builder.add(ConsecutiveUpperCaseLetters.of(password));
        builder.add(ConsecutiveLowerCaseLetters.of(password));
        builder.add(ConsecutiveNumbers.of(password));
        builder.add(SequencialLetters.of(password));
        builder.add(SequencialNumbers.of(password));
        builder.add(SequencialSymbols.of(password));

        return builder.build();
    }

}
