package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SequencialNumbersTest {

    @Test
    public void test() throws Exception {
        assertThat(SequencialNumbers.of(PasswordDataProvider.EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialNumbers.of(PasswordDataProvider.ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialNumbers.of(PasswordDataProvider.ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialNumbers.of(PasswordDataProvider.ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialNumbers.of(PasswordDataProvider.EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(-18));
        assertThat(SequencialNumbers.of(PasswordDataProvider.EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialNumbers.of(PasswordDataProvider.EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialNumbers.of(PasswordDataProvider.EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialNumbers.of(PasswordDataProvider.EXCEPTIONAL).getScore()).isEqualTo(Score.of(0));

        assertThat(SequencialNumbers.of(Password.of("abcdefgrstu")).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialNumbers.of(Password.of("abc123#$%")).getScore()).isEqualTo(Score.of(-3));
    }
    
}