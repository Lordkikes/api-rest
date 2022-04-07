package com.yelko.app.apirest.validator;

import com.yelko.app.apirest.dto.UserRequest;
import com.yelko.app.apirest.utils.exceptions.ApiUnprocessableEntityException;
import org.springframework.stereotype.Component;

/**
* @author Enrique Navarro (Lordkikes)
* @version 1.0
* @since 07/04/2022
 */

@Component
public class UserValidatorImpl implements UsersValidator{

    @Override
    public void validator(UserRequest request) throws ApiUnprocessableEntityException {

        if(request.getFirstName() == null || request.getFirstName().isEmpty()){
            this.message("The name is required");
        }
        if (request.getFirstName().length() < 3){
           this.message("The name is very short, it must have at least 3 letters ");
        }
        if (request.getLastName()==null || request.getLastName().isEmpty()){
            this.message("The lastName is required");
        }
        if (request.getUsername().length() < 3){
            this.message("The Username is very short, it must have at least 6 letters ");
        }
        if (request.getUsername()==null || request.getUsername().isEmpty()){
            this.message("The Username is required");
        }
        if (request.getPassword()==null || request.getPassword().isEmpty()){
            this.message("The Password is required");
        }
        if (request.getPassword().length() < 3){
            this.message("The Password is very short, it must have at least 8 letters ");
        }

    }

    private void message(String message) throws ApiUnprocessableEntityException{
        throw new ApiUnprocessableEntityException(message);
    }
}
