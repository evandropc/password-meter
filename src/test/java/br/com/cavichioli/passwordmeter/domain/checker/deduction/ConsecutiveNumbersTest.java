package br.com.cavichioli.passwordmeter.domain.checker.deduction;

import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;

import static br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsecutiveNumbersTest {

    @Test
    public void test() throws Exception {
        assertThat(ConsecutiveNumbers.of(EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(-14));
        assertThat(ConsecutiveNumbers.of(EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(EXCEPTIONAL).getScore()).isEqualTo(Score.of(0));

        assertThat(ConsecutiveNumbers.of(Password.of("AAAA")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(Password.of("aaaa")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(Password.of("1q1q1q")).getScore()).isEqualTo(Score.of(0));
        assertThat(ConsecutiveNumbers.of(Password.of("11")).getScore()).isEqualTo(Score.of(-2));
        assertThat(ConsecutiveNumbers.of(Password.of("1234")).getScore()).isEqualTo(Score.of(-6));
        assertThat(ConsecutiveNumbers.of(Password.of("112233445")).getScore()).isEqualTo(Score.of(-16));
        assertThat(ConsecutiveNumbers.of(Password.of("22e33")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveNumbers.of(Password.of("22E33")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveNumbers.of(Password.of("22@33")).getScore()).isEqualTo(Score.of(-4));
        assertThat(ConsecutiveNumbers.of(Password.of("112_23")).getScore()).isEqualTo(Score.of(-6));
        assertThat(ConsecutiveNumbers.of(Password.of("1A222rs@345w44")).getScore()).isEqualTo(Score.of(-10));
    }

}