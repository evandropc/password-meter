package br.com.cavichioli.passwordmeter.domain.checker;

import br.com.cavichioli.passwordmeter.domain.Score.Score;

import java.io.Serializable;

public interface Checker extends Serializable {

    public Score getScore();

}
