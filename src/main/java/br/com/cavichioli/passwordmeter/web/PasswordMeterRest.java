package br.com.cavichioli.passwordmeter.web;

import br.com.cavichioli.passwordmeter.domain.PasswordMeter;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PasswordMeterRest {

	@ResponseBody
	@RequestMapping(value = "/rest/password-check/{password}", method = RequestMethod.GET)
	public ResponseEntity<PasswordMeter> check(@PathVariable Password password) {
		return new ResponseEntity(PasswordMeter.of(password), HttpStatus.OK);
	}

}
