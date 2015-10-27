package br.com.cavichioli.passwordmeter.domain.password;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordTest {

    @Test
    public void testOf() throws Exception {
        assertThat(Password.of(null).getValue()).isEqualTo("");
        assertThat(Password.of("").getValue()).isEqualTo("");
        assertThat(Password.of("asewg234").getValue()).isEqualTo("asewg234");
    }

    @Test
    public void testOfWithSpaces() throws Exception {
        assertThat(Password.of("  ").getValue()).isEqualTo("");
        assertThat(Password.of("asew  g2 34").getValue()).isEqualTo("asewg234");
    }

    @Test
     public void testLenght() throws Exception {
        assertThat(Password.of("").getLength()).isEqualTo(0);
        assertThat(Password.of("asewg234").getLength()).isEqualTo(8);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertThat(Password.of(null).isEmpty()).isTrue();
        assertThat(Password.of("").isEmpty()).isTrue();
        assertThat(Password.of("asewg234").isEmpty()).isFalse();
    }

}