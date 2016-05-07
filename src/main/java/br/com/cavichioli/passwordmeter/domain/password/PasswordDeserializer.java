package br.com.cavichioli.passwordmeter.domain.password;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Strings;

import java.io.IOException;

public class PasswordDeserializer extends JsonDeserializer<Password> {

	@Override
	public Password deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		if (!Strings.isNullOrEmpty(jp.getText())) {
			return Password.of(jp.getText());
		}
		return null;
	}

}
