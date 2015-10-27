package br.com.cavichioli.passwordmeter.domain.complexity;

import br.com.cavichioli.passwordmeter.domain.Score.Score;
import com.google.common.collect.Range;

import java.util.stream.Stream;

public enum Complexity {

    VERY_WEAK(Range.lessThan(20)),
    WEAK(Range.closedOpen(20, 40)),
    GOOD(Range.closedOpen(40, 60)),
    STRONG(Range.closedOpen(60, 80)),
    VERY_STRONG(Range.greaterThan(79));

    private final Range range;

    private Complexity(Range range) {
        this.range = range;
    }

    public static Complexity of(Score score) {
        return Stream.of(values())
                .filter(c -> c.range.contains(score.getValue()))
                .findFirst()
                .orElse(VERY_WEAK);
    }

    public Range getRange() {
        return range;
    }

    @Override
    public String toString() {
        return name();
    }

}
