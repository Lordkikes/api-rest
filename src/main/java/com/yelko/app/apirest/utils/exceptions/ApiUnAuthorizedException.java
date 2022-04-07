package com.yelko.app.apirest.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Personalizada de status 401
 * @author Enrique Navarro (Lordkikes)
 * @version 1.0
 * @since 07/04/2022
 *
 */

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnAuthorizedException extends Exception{

    public ApiUnAuthorizedException(String message) {

        super(message);

    }
}
