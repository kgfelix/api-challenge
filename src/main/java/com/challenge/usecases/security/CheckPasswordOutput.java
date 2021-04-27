package com.challenge.usecases.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.challenge.usecases.Output;

/**
 * Implementa uma interface de saída para o caso de uso de validação de senha
 * 
 * @author Kleber Felix
 * @version 1.0
 * @since 2021-04-24
 */
@Component
@Qualifier("CheckPasswordOutput")
public class CheckPasswordOutput implements Output {

	private Boolean success;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
