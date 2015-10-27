package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;
import static br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsecutiveUpperCaseLettersTest {

    @Test
    public void test() throws Exception {
        assertThat(ConsecutiveUpperCaseLetters.of(EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(EXCEPTIONAL).getScore()).isEqualTo(Score.of(0));

        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("aaaa")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("A")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("AA")).getScore()).isEqualTo(Score.of(-2));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("AAAA")).getScore()).isEqualTo(Score.of(-6));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("AAAABBCC")).getScore()).isEqualTo(Score.of(-14));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("AA7AA")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("AAaAA")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("AA@AA")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("A@Q@W@E@R@T")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveUpperCaseLetters.of(Password.of("ArdhBsAA")).getScore()).isEqualTo(Score.of(-2));
    }

}