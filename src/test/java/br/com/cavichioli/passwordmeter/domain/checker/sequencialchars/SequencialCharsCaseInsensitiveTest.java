package br.com.cavichioli.passwordmeter.domain.checker.sequencialchars;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SequencialCharsCaseInsensitiveTest {

    @Test
    public void checkTrue() {
        assertThat(SequencialCharsCaseInsensitive.of("abcd", "abcd").isSequencial()).isTrue();
        assertThat(SequencialCharsCaseInsensitive.of("dcba", "abcd").isSequencial()).isTrue();
        assertThat(SequencialCharsCaseInsensitive.of("abcd", "abcd235236").isSequencial()).isTrue();
        assertThat(SequencialCharsCaseInsensitive.of("1234", "1234").isSequencial()).isTrue();
        assertThat(SequencialCharsCaseInsensitive.of("1234", "4321gdsr").isSequencial()).isTrue();
        assertThat(SequencialCharsCaseInsensitive.of("4321", "1234gdsr").isSequencial()).isTrue();
        assertThat(SequencialCharsCaseInsensitive.of("!@#$", "!@#$").isSequencial()).isTrue();
        assertThat(SequencialCharsCaseInsensitive.of("$#@!", "!@#$").isSequencial()).isTrue();
        assertThat(SequencialCharsCaseInsensitive.of("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz").isSequencial()).isTrue();
    }

    @Test
    public void checkFalse() {
        assertThat(SequencialCharsCaseInsensitive.of("abcd", "ab3cd").isSequencial()).isFalse();
        assertThat(SequencialCharsCaseInsensitive.of("dcba", "abc4d").isSequencial()).isFalse();
        assertThat(SequencialCharsCaseInsensitive.of("abcd", "ab2cd235236").isSequencial()).isFalse();
        assertThat(SequencialCharsCaseInsensitive.of("1234", "12r34").isSequencial()).isFalse();
        assertThat(SequencialCharsCaseInsensitive.of("1234", "43s21gdsr").isSequencial()).isFalse();
        assertThat(SequencialCharsCaseInsensitive.of("4321", "12g34gdsr").isSequencial()).isFalse();
        assertThat(SequencialCharsCaseInsensitive.of("!@#$", "!@e#$").isSequencial()).isFalse();
        assertThat(SequencialCharsCaseInsensitive.of("$#@!", "!@y#$").isSequencial()).isFalse();
        assertThat(SequencialCharsCaseInsensitive.of("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmno7pqrstuvwxyz").isSequencial()).isFalse();
    }

}