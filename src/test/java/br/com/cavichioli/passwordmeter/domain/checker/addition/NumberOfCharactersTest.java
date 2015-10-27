package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider.*;

public class NumberOfCharactersTest {

    @Test
    public void test() throws Exception {
        assertThat(NumberOfCharacters.of(EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(NumberOfCharacters.of(ONE_NUMBER).getScore()).isEqualTo(Score.of(4));
        assertThat(NumberOfCharacters.of(ONE_CARACTER).getScore()).isEqualTo(Score.of(4));
        assertThat(NumberOfCharacters.of(ONE_SYMBOL).getScore()).isEqualTo(Score.of(4));
        assertThat(NumberOfCharacters.of(EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(32));
        assertThat(NumberOfCharacters.of(EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(32));
        assertThat(NumberOfCharacters.of(EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(32));
        assertThat(NumberOfCharacters.of(EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(32));
        assertThat(NumberOfCharacters.of(EXCEPTIONAL).getScore()).isEqualTo(Score.of(36));
    }

}