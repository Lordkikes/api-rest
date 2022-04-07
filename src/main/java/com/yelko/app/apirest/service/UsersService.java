package com.yelko.app.apirest.service;

import com.yelko.app.apirest.dto.UserRequest;
import com.yelko.app.apirest.dto.UsersDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    List<UsersDTO> findAll();

    UsersDTO findByUsername(String username);

    UsersDTO findById(Long id);

    void save(UserRequest user);

    void saveAll(List<UserRequest> users);

    void deleteById(Long id);

    void update(UserRequest user, Long id);

}
