package com.challenge.usecases.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.challenge.usecases.Input;

/**
 * Implementa uma interface de entrada para o caso de uso de validação de senha
 * 
 * @author Kleber Felix
 * @version 1.0
 * @since 2021-04-24
 */
@Component
@Qualifier("CheckPasswordInput")
public class CheckPasswordInput implements Input {
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

}
