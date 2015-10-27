package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterOnlyTest {

    @Test
    public void test() throws Exception {
        assertThat(LetterOnly.of(PasswordDataProvider.EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(PasswordDataProvider.ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(PasswordDataProvider.ONE_CARACTER).getScore()).isEqualTo(Score.of(-1));
        assertThat(LetterOnly.of(PasswordDataProvider.ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(PasswordDataProvider.EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(PasswordDataProvider.EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(PasswordDataProvider.EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(PasswordDataProvider.EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(PasswordDataProvider.EXCEPTIONAL).getScore()).isEqualTo(Score.of(0));

        assertThat(LetterOnly.of(Password.of("Ba7")).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(Password.of("Ba#")).getScore()).isEqualTo(Score.of(0));
        assertThat(LetterOnly.of(Password.of("Bazw")).getScore()).isEqualTo(Score.of(-4));
        assertThat(LetterOnly.of(Password.of("az")).getScore()).isEqualTo(Score.of(-2));
    }

}