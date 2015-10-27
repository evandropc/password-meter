package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider;
import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MiddleNumbersOrSymbolsTest {

    @Test
    public void test() throws Exception {
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(12));
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(12));
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(6));
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(10));
        assertThat(MiddleNumbersOrSymbols.of(PasswordDataProvider.EXCEPTIONAL).getScore()).isEqualTo(Score.of(8));
    }

}