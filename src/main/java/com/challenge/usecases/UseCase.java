package com.challenge.usecases;

import org.springframework.stereotype.Component;

/**
 * Interface que define os métodos que devem ser implementados por um caso de uso.
 * 
 * @author Kleber Felix
 * @version 1.0
 * @since 2021-04-24
 */
@Component
public interface UseCase {
	
	 Output execute(Input input);

}
