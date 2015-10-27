package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider;
import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SequencialLettersTest {

    @Test
    public void test() throws Exception {
        assertThat(SequencialLetters.of(PasswordDataProvider.EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialLetters.of(PasswordDataProvider.ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialLetters.of(PasswordDataProvider.ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialLetters.of(PasswordDataProvider.ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialLetters.of(PasswordDataProvider.EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialLetters.of(PasswordDataProvider.EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialLetters.of(PasswordDataProvider.EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialLetters.of(PasswordDataProvider.EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(0));
        assertThat(SequencialLetters.of(PasswordDataProvider.EXCEPTIONAL).getScore()).isEqualTo(Score.of(0));

        assertThat(SequencialLetters.of(Password.of("abcdefgrstu")).getScore()).isEqualTo(Score.of(-21));
        assertThat(SequencialLetters.of(Password.of("abc123#$%")).getScore()).isEqualTo(Score.of(-3));
        assertThat(SequencialLetters.of(Password.of("abC123#$%")).getScore()).isEqualTo(Score.of(-3));
    }

}