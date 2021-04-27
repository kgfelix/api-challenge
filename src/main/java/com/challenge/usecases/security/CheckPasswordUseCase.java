package com.challenge.usecases.security;

import com.challenge.usecases.Input;
import com.challenge.usecases.Output;
import com.challenge.usecases.UseCase;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Implementa um caso de uso para validação de senha, de acordo com as 
 * regras pré-definidas pelo projeto:
 * 
 * Nove ou mais caracteres;
 * Ao menos 1 dígito;
 * Ao menos 1 letra minúscula;
 * Ao menos 1 letra maiúscula;
 * Ao menos 1 caractere especial do conjunto: '!@#$%^&*()-+';
 * Não possuir caracteres repetidos dentro do conjunto;
 * 
 * @author Kleber Felix
 * @version 1.0
 * @since 2021-04-24
 */
@Component
@Qualifier("CheckPasswordUseCase")
public class CheckPasswordUseCase implements UseCase {

	final int PASSWORD_MIN_LENGTH = 9;

	@Override
	public Output execute(Input input) {
		CheckPasswordInput in = (CheckPasswordInput) input;
		CheckPasswordOutput output = new CheckPasswordOutput();
		output.setSuccess(checkValidPassword(in.getPassword()));
		return output;
	}

	private boolean checkValidPassword(String password) {
		/*
		* A senha não pode ser nula, string vazia ou menor do que 9
		*/
		if (password == null || password.equals("") || password.length() < PASSWORD_MIN_LENGTH){
			return false;
		}
		/**
		 * Senha não pode contar espaços vazios
		 */

		if (password.contains(" ")){
			return false;
		}

		String specialCharacter = "!@#$%^&*()-+";
		boolean hasDigit = false;
		boolean hasLowerCase = false;
		boolean hasUperCase = false;
		boolean hasSpecialChar = false;
		boolean haveRepeatedChar = false;

		StringBuilder sb = new StringBuilder();
		for (char ch: password.toCharArray()) {
			// Valida se contém um dígito			
			if (Character.isDigit(ch)) {
				hasDigit = true;
			// Valida se contém letra minúscula
			} else if (Character.isLowerCase(ch)) {
				hasLowerCase = true;
			// Valida se contém letra maiúscula
			} else if (Character.isUpperCase(ch)) {
				hasUperCase = true;
			// Valida se contém caractere especial
			} else if (specialCharacter.contains(String.valueOf(ch))) {
				hasSpecialChar = true;
			}
			// Valida se contém  caractere repetido
			if ( sb.toString().contains(String.valueOf(ch)) ) {
				haveRepeatedChar = true;
			}
			sb.append(ch);
		}

		return hasDigit && hasLowerCase && hasUperCase && hasSpecialChar && !haveRepeatedChar;
	}
}
