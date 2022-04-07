package com.yelko.app.apirest.validator;

import com.yelko.app.apirest.dto.UserRequest;
import com.yelko.app.apirest.utils.exceptions.ApiUnprocessableEntityException;
import org.springframework.stereotype.Service;

/**
 * Interface para la validacion de los datos recibidos
 * para la creacion de usuarios
 *  @author Enrique Navarro (Lordkikes)
 *  @version 1.0
 *  @since 07/04/2022
 */

@Service
public interface UsersValidator {

    void validator(UserRequest request) throws ApiUnprocessableEntityException;

}
