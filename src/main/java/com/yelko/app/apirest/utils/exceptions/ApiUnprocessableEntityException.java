package com.yelko.app.apirest.utils.exceptions;

/**
 * Exception Personalizada de status 422
 * @author Enrique Navarro (Lordkikes)
 * @version 1.0
 * @since 07/04/2022
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntityException extends Exception{

    public ApiUnprocessableEntityException(String message) {
        super(message);
    }


}
