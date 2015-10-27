package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsecutiveLowerCaseLettersTest {

    @Test
    public void test() throws Exception {
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(PasswordDataProvider.EXCEPTIONAL).getScore()).isEqualTo(Score.of(0));

        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("AAAA")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("a")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("a@a#@#")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("aa")).getScore()).isEqualTo(Score.of(-2));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("aaaa")).getScore()).isEqualTo(Score.of(-6));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("aabbccdde")).getScore()).isEqualTo(Score.of(-16));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("aa7aa")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("aaBaa")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("aa@aa")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("aaz_aa")).getScore()).isEqualTo(Score.of(-6));
        assertThat(ConsecutiveLowerCaseLetters.of(Password.of("ArdhhBsaa")).getScore()).isEqualTo(Score.of(-10));
    }

}