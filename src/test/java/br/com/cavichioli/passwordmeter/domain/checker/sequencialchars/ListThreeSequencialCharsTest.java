package br.com.cavichioli.passwordmeter.domain.checker.sequencialchars;

import com.google.common.collect.ImmutableList;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ListThreeSequencialCharsTest {

    @Test
    public void checkSequecials() {
        assertThat(ListThreeSequencialChars.alphas("abcdLMNOrs").getSequencials())
                .isEqualTo(ImmutableList.of(
                        SequencialCharsCaseInsensitive.of("abc", "abc"),
                        SequencialCharsCaseInsensitive.of("bcd", "bcd"),
                        SequencialCharsCaseInsensitive.of("lmn", "lmn"),
                        SequencialCharsCaseInsensitive.of("mno", "mno")));

        assertThat(ListThreeSequencialChars.alphas("abc123").getSequencials())
                .isEqualTo(ImmutableList.of(
                        SequencialCharsCaseInsensitive.of("abc", "abc")));

        assertThat(ListThreeSequencialChars.symbols("@#$111111").getSequencials())
                .isEqualTo(ImmutableList.of(
                        SequencialCharsCaseInsensitive.of("@#$","@#$")));

        assertThat(ListThreeSequencialChars.numbers("abc#$%123").getSequencials())
                .isEqualTo(ImmutableList.of(
                        SequencialCharsCaseInsensitive.of("123", "123")));

        assertThat(ListThreeSequencialChars.symbols("!@#$%*()").getSequencials())
                .isEqualTo(ImmutableList.of(
                        SequencialCharsCaseInsensitive.of("!@#", "!@#"),
                        SequencialCharsCaseInsensitive.of("@#$", "@#$"),
                        SequencialCharsCaseInsensitive.of("#$%", "#$%")));
    }

}