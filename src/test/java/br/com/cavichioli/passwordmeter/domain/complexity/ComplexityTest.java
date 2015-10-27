package br.com.cavichioli.passwordmeter.domain.complexity;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComplexityTest {

    @Test
    public void test() {
        assertThat(Complexity.of(Score.of(-20))).isEqualTo(Complexity.VERY_WEAK);

        assertThat(Complexity.of(Score.of(0))).isEqualTo(Complexity.VERY_WEAK);
        assertThat(Complexity.of(Score.of(19))).isEqualTo(Complexity.VERY_WEAK);

        assertThat(Complexity.of(Score.of(20))).isEqualTo(Complexity.WEAK);
        assertThat(Complexity.of(Score.of(39))).isEqualTo(Complexity.WEAK);

        assertThat(Complexity.of(Score.of(40))).isEqualTo(Complexity.GOOD);
        assertThat(Complexity.of(Score.of(59))).isEqualTo(Complexity.GOOD);

        assertThat(Complexity.of(Score.of(60))).isEqualTo(Complexity.STRONG);
        assertThat(Complexity.of(Score.of(79))).isEqualTo(Complexity.STRONG);

        assertThat(Complexity.of(Score.of(80))).isEqualTo(Complexity.VERY_STRONG);
        assertThat(Complexity.of(Score.of(100))).isEqualTo(Complexity.VERY_STRONG);
        assertThat(Complexity.of(Score.of(10000))).isEqualTo(Complexity.VERY_STRONG);
    }
}