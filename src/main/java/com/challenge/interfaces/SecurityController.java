package com.challenge.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.usecases.Input;
import com.challenge.usecases.Output;
import com.challenge.usecases.UseCase;
import com.challenge.usecases.security.CheckPasswordInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Responsável pela comunicação externa da API.
 * Recebe entradas, converte-as no modelo do caso de use e passa as 
 * informações para o mesmo;
 * 
 * @author Kleber Felix
 * @version 1.0
 * @since 2021-04-24
 */
@RestController
@RequestMapping("/v1/itidigital/security")
public class SecurityController {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	@Qualifier("CheckPasswordUseCase")
	private UseCase checkPasswordUseCase;

	/**
	 * Método responsável em invocar o caso de uso que irá validar a senha
	 */
	@GetMapping(value = "/validate")
	public String checkPassword(@RequestBody String security) throws JsonMappingException, 
	JsonProcessingException {
		Input input = objectMapper.readValue(security, CheckPasswordInput.class);
		Output output = checkPasswordUseCase.execute(input);
		String response = objectMapper.writeValueAsString(output);
		return response;
	}	

}
