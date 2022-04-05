package com.yelko.app.apirest.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UsersDTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Date ceatedAt;
    private Date updatedAt;
}
