package br.com.cavichioli.passwordmeter.domain.Score;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

public class Score implements Serializable{

    public static final Score ZERO = Score.of(0);

    private Integer value;

    private Score(Integer value) {
        this.value = value;
    }

    public static Score of(Integer value) {
        checkNotNull(value, "value não pode ser null");
        return new Score(value);
    }

    public Score sum(Score score) {
        checkNotNull(score, "score não pode ser null");
        return Score.of(value + score.value);
    }

    public Score negative() {
        if (value > 0) {
            return Score.of(value * -1);
        }
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Score) {
            Score other = (Score) object;
            return Objects.equal(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", value).toString();
    }

    public Integer getValue() {
        return value;
    }

}
