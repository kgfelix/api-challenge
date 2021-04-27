package com.challenge.usecases.security;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.usecases.UseCase;

@SpringBootTest
class CheckPasswordUseCaseTests {
	
	@Autowired
	@Qualifier("CheckPasswordUseCase")
	private UseCase checkPasswordUseCase = new CheckPasswordUseCase();

	CheckPasswordInput input = new CheckPasswordInput();

	/**
	 * Deve retornar falso quando a senha é nula
	 */
	@Test
	void shouldRetrunFalsePasswordNull() {
		input.setPassword(null);
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);		
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso quando a senha é uma string vazia
	 */
	@Test
	void shouldReturnFalseWhenPasswordIsEmpty() {		
		input.setPassword("");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso quando a senha tem menos de 9 caracteres
	 */
	@Test
	void shouldReturnFalseLessThanNine() {		
		input.setPassword("AbTp9!f");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso quando a senha não possuir caractere especial
	 */
	@Test
	void shouldReturnFalseWithoutSpecialCharacter() {		
		input.setPassword("AbTp9zfok");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso quando a senha não possuir caractere especial
	 * que não pertença ao conjunto
	 */
	@Test
	void shouldReturnFalseSpecialCharacterWithoutSet() {		
		input.setPassword("AbTp9?fok");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso quando a senha não possuir dígito
	 */
	@Test
	void shouldReturnFalseWithoutDigit() {		
		input.setPassword("AbTpz!fok");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso quando a senha não possuir letra maiúscula
	 */
	@Test
	void shouldReturnFalseWithoutUpperCase() {		
		input.setPassword("abtp9!fok");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso quando a senha não possuir letra minúscula
	 */
	@Test
	void shouldReturnFalseWithoutLowerCase() {		
		input.setPassword("ABTP9!FOK");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso quando a senha possuir espaço
	 */
	@Test
	void shouldReturnFalseWithSpace() {		
		input.setPassword("AbT 9!fok");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar falso com caracteres repetidos dentro do conjunto 
	 */
	@Test
	void shouldReturnFalseWithCharSequence() {		
		input.setPassword("AAbTp9!fkk");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertFalse(output.getSuccess());
	}

	/**
	 * Deve retornar true, senha OK
	 */
	@Test
	void shouldReturnTruePasswordOK() {		
		input.setPassword("AbTp9!fok");
		CheckPasswordOutput output = (CheckPasswordOutput) checkPasswordUseCase.execute(input);
		assertTrue(output.getSuccess());
	}

}
