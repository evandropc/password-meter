package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;

import static br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NumbersOnlyTest {

    @Test
    public void test() throws Exception {
        assertThat(NumbersOnly.of(EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(NumbersOnly.of(ONE_NUMBER).getScore()).isEqualTo(Score.of(-1));
        assertThat(NumbersOnly.of(ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(NumbersOnly.of(ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(NumbersOnly.of(EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(-8));
        assertThat(NumbersOnly.of(EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(NumbersOnly.of(EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(NumbersOnly.of(EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(0));
        assertThat(NumbersOnly.of(EXCEPTIONAL).getScore()).isEqualTo(Score.of(0));
    }

}