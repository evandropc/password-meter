package br.com.cavichioli.passwordmeter.domain;

import br.com.cavichioli.passwordmeter.domain.checker.Checker;
import br.com.cavichioli.passwordmeter.domain.checker.CheckerFactory;
import br.com.cavichioli.passwordmeter.domain.complexity.Complexity;
import br.com.cavichioli.passwordmeter.domain.complexity.ComplexitySerializer;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import br.com.cavichioli.passwordmeter.domain.password.PasswordSerializer;
import br.com.cavichioli.passwordmeter.domain.Score.Score;
import br.com.cavichioli.passwordmeter.domain.Score.ScoreSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import java.io.Serializable;

public class PasswordMeter implements Serializable {

    @JsonSerialize(using = PasswordSerializer.class)
    private final Password password;

    @JsonSerialize(using = ScoreSerializer.class)
    private final Score score;

    @JsonSerialize(using = ComplexitySerializer.class)
    private final Complexity complexity;

    private PasswordMeter(Password password) {
        this.password = password;
        this.score = processScore();
        this.complexity = rangeComplexity();
    }

    public static PasswordMeter of(Password password) {
        Preconditions.checkNotNull(password, "Password não pode ser null");
        return new PasswordMeter(password);
    }

    private Score processScore() {
        return CheckerFactory.of(password).stream()
                .map(Checker::getScore)
                .reduce(Score.ZERO, Score::sum);
    }

    private Complexity rangeComplexity() {
        return Complexity.of(score);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof PasswordMeter) {
            PasswordMeter other = (PasswordMeter) object;
            return Objects.equal(this.password, other.password);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(password);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("password", password)
                .add("score", score)
                .add("complexity", complexity).toString();
    }

    public Password getPassword() {
        return password;
    }

    public Score getScore() {
        return score;
    }

    public Complexity getComplexity() {
        return complexity;
    }

}
