package com.yelko.app.apirest.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception Personalizada de status 404
 * @author Enrique Navarro (Lordkikes)
 * @version 1.0
 * @since 07/04/2022
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNotFoundException extends  Exception{

    public ApiNotFoundException(String message) {
        super(message);
    }
}
