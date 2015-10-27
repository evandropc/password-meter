package br.com.cavichioli.passwordmeter.domain.score;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    public void testOf() throws Exception {
        Assertions.assertThat(Score.of(10).getValue()).isEqualTo(10);
        assertThat(Score.of(-10).getValue()).isEqualTo(-10);
    }

    @Test
     public void testSum() throws Exception {
        assertThat(Score.of(4).sum(Score.of(36)).sum(Score.of(-8))).isEqualTo(Score.of(32));
        assertThat(Score.of(-4).sum(Score.of(-36)).sum(Score.of(8))).isEqualTo(Score.of(-32));
    }

    @Test
    public void testNegative() throws Exception {
        assertThat(Score.of(10).negative()).isEqualTo(Score.of(-10));
        assertThat(Score.of(-10).negative()).isEqualTo(Score.of(-10));
    }

}