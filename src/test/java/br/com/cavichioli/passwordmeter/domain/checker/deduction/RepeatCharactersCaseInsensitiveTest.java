package br.com.cavichioli.passwordmeter.domain.checker.deduction;


import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;

import static br.com.cavichioli.passwordmeter.domain.password.Password.of;
import static org.assertj.core.api.Assertions.assertThat;
import static br.com.cavichioli.passwordmeter.domain.password.PasswordDataProvider.*;

public class RepeatCharactersCaseInsensitiveTest {

    @Test
    public void test() throws Exception {
        assertThat(RepeatCharactersCaseInsensitive.of(EMPTY).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(ONE_NUMBER).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(ONE_CARACTER).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(ONE_SYMBOL).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(EIGHT_NUMBERS).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(EIGHT_SYMBOLS).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(EIGHT_CARACT_NUM).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(EIGHT_CARACT_NUM_SYMB).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(EXCEPTIONAL).getScore()).isEqualTo(Score.of(0));
        assertThat(RepeatCharactersCaseInsensitive.of(of("aaaa")).getScore()).isEqualTo(Score.of(-25));
        assertThat(RepeatCharactersCaseInsensitive.of(of("aabb")).getScore()).isEqualTo(Score.of(-11));
        assertThat(RepeatCharactersCaseInsensitive.of(of("11")).getScore()).isEqualTo(Score.of(-4));
        assertThat(RepeatCharactersCaseInsensitive.of(of("@@@")).getScore()).isEqualTo(Score.of(-14));
        assertThat(RepeatCharactersCaseInsensitive.of(of("@@@aaa")).getScore()).isEqualTo(Score.of(-28));
        assertThat(RepeatCharactersCaseInsensitive.of(of("@@@aaa112233")).getScore()).isEqualTo(Score.of(-33));
    }

}