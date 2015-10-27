package br.com.cavichioli.passwordmeter.domain;

import br.com.cavichioli.passwordmeter.domain.complexity.Complexity;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;
import static br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordMeterTest {

    @Test
    public void testVeryWeak() {
        PasswordMeter ofVazia = PasswordMeter.of(EMPTY);
        assertThat(ofVazia.getPassword()).isEqualTo(EMPTY);
        assertThat(ofVazia.getScore()).isEqualTo(Score.of(0));
        assertThat(ofVazia.getComplexity()).isEqualTo(Complexity.VERY_WEAK);

        PasswordMeter umCaracter = PasswordMeter.of(ONE_CARACTER);
        assertThat(umCaracter.getPassword()).isEqualTo(ONE_CARACTER);
        assertThat(umCaracter.getScore()).isEqualTo(Score.of(3));
        assertThat(umCaracter.getComplexity()).isEqualTo(Complexity.VERY_WEAK);

        PasswordMeter ofOitoNumeros = PasswordMeter.of(EIGHT_NUMBERS);
        assertThat(ofOitoNumeros.getPassword()).isEqualTo(EIGHT_NUMBERS);
        assertThat(ofOitoNumeros.getScore()).isEqualTo(Score.of(4));
        assertThat(ofOitoNumeros.getComplexity()).isEqualTo(Complexity.VERY_WEAK);
    }

    @Test
    public void testWeak() {
        Password ba7 = Password.of("Ba7");
        PasswordMeter pwdMeter = PasswordMeter.of(ba7);
        assertThat(pwdMeter.getPassword()).isEqualTo(ba7);
        assertThat(pwdMeter.getScore()).isEqualTo(Score.of(24));
        assertThat(pwdMeter.getComplexity()).isEqualTo(Complexity.WEAK);
    }

    @Test
    public void testGood() {
        Password ba7 = Password.of("Ba7#");
        PasswordMeter pwdMeter = PasswordMeter.of(ba7);
        assertThat(pwdMeter.getPassword()).isEqualTo(ba7);
        assertThat(pwdMeter.getScore()).isEqualTo(Score.of(40));
        assertThat(pwdMeter.getComplexity()).isEqualTo(Complexity.GOOD);
    }

    @Test
    public void testStrong() {
        PasswordMeter pwdMeter = PasswordMeter.of(EIGHT_CARACT_NUM);
        assertThat(pwdMeter.getPassword()).isEqualTo(EIGHT_CARACT_NUM);
        assertThat(pwdMeter.getScore()).isEqualTo(Score.of(62));
        assertThat(pwdMeter.getComplexity()).isEqualTo(Complexity.STRONG);
    }

    @Test
    public void testVeryStrong() {
        PasswordMeter pwdMeter = PasswordMeter.of(EIGHT_SYMBOLS);
        assertThat(pwdMeter.getPassword()).isEqualTo(EIGHT_SYMBOLS);
        assertThat(pwdMeter.getScore()).isEqualTo(Score.of(83));
        assertThat(pwdMeter.getComplexity()).isEqualTo(Complexity.VERY_STRONG);

        PasswordMeter pwdMeterExcep = PasswordMeter.of(EXCEPTIONAL);
        assertThat(pwdMeterExcep.getPassword()).isEqualTo(EXCEPTIONAL);
        assertThat(pwdMeterExcep.getScore()).isEqualTo(Score.of(100));
        assertThat(pwdMeterExcep.getComplexity()).isEqualTo(Complexity.VERY_STRONG);

        PasswordMeter pwdMeterCNS = PasswordMeter.of(EIGHT_CARACT_NUM_SYMB);
        assertThat(pwdMeterCNS.getPassword()).isEqualTo(EIGHT_CARACT_NUM_SYMB);
        assertThat(pwdMeterCNS.getScore()).isEqualTo(Score.of(110));
        assertThat(pwdMeterCNS.getComplexity()).isEqualTo(Complexity.VERY_STRONG);
    }

    @Test
    private void testAll(){
        assertThat(PasswordMeter.of(Password.of("aaaa")).getScore()).isEqualTo(Score.of(-19));
        assertThat(PasswordMeter.of(Password.of("@@@aaa112233")).getScore()).isEqualTo(Score.of(83));
        assertThat(PasswordMeter.of(Password.of("m28sksb28")).getScore()).isEqualTo(Score.of(55));
        assertThat(PasswordMeter.of(Password.of("72529@#%@")).getScore()).isEqualTo(Score.of(85));
        assertThat(PasswordMeter.of(Password.of("aaaaaaaaaa")).getScore()).isEqualTo(Score.of(-85));
        assertThat(PasswordMeter.of(Password.of("111")).getScore()).isEqualTo(Score.of(-7));
        assertThat(PasswordMeter.of(Password.of("111AAA")).getScore()).isEqualTo(Score.of(10));
        assertThat(PasswordMeter.of(Password.of("111aaa")).getScore()).isEqualTo(Score.of(10));
        assertThat(PasswordMeter.of(Password.of("abc123!@#")).getScore()).isEqualTo(Score.of(79));
        assertThat(PasswordMeter.of(Password.of("abc123!@#AAA")).getScore()).isEqualTo(Score.of(112));
    }

}