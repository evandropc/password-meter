package br.com.cavichioli.passwordmeter.web;

import br.com.cavichioli.passwordmeter.domain.PasswordMeter;
import br.com.cavichioli.passwordmeter.domain.password.Password;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PasswordMeterRest {

	@RequestMapping(value = "/rest/password-check/{password}" , method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<PasswordMeter> categoriaEmpresaPorId(@PathVariable String password) {
		return new ResponseEntity(PasswordMeter.of(Password.of(password)), HttpStatus.OK);
	}

}
