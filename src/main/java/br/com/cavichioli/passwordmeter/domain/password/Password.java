package br.com.cavichioli.passwordmeter.domain.password;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Optional;

@JsonSerialize(using = PasswordSerializer.class)
@JsonDeserialize(using = PasswordDeserializer.class)
public class Password implements Serializable {

	private final String value;

	private Password(String value) {
		value = Optional.ofNullable(value).orElse("");
		this.value = value.replaceAll("\\s", "");
	}

	public static Password of(String value) {
		return new Password(value);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Password) {
			Password other = (Password) object;
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

	public int getLength() {
		return value.length();
	}

	public boolean isEmpty() {
		return value.length() == 0;
	}

	public String getValue() {
		return value;
	}

}
