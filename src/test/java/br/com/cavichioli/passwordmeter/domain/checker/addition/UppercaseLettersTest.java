package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider.*;

public class UppercaseLettersTest {

    @Test
    public void test() throws Exception {
        assertThat(UppercaseLetters.of(EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(UppercaseLetters.of(ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(UppercaseLetters.of(ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(UppercaseLetters.of(ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(UppercaseLetters.of(EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(0));
        assertThat(UppercaseLetters.of(EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(UppercaseLetters.of(EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(UppercaseLetters.of(EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(14));
        assertThat(UppercaseLetters.of(EXCEPTIONAL).getScore()).isEqualTo(Score.of(14));
    }

}