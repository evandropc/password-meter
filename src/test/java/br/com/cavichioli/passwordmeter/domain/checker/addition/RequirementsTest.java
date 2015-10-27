package br.com.cavichioli.passwordmeter.domain.checker.addition;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequirementsTest {

    @Test
    public void test() throws Exception {
        Assertions.assertThat(Requirements.of(PasswordDataProvider.EMPTY).getScore()).isEqualTo(Score.of(0));
        Assertions.assertThat(Requirements.of(PasswordDataProvider.ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        Assertions.assertThat(Requirements.of(PasswordDataProvider.ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        Assertions.assertThat(Requirements.of(PasswordDataProvider.ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        Assertions.assertThat(Requirements.of(PasswordDataProvider.EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(0));
        Assertions.assertThat(Requirements.of(PasswordDataProvider.EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        Assertions.assertThat(Requirements.of(PasswordDataProvider.EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        Assertions.assertThat(Requirements.of(PasswordDataProvider.EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(10));
        Assertions.assertThat(Requirements.of(PasswordDataProvider.EXCEPTIONAL).getScore()).isEqualTo(Score.of(10));
    }

}