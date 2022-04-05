package com.yelko.app.apirest.service;

import com.yelko.app.apirest.dto.UsersDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersService {

    List<UsersDTO> findAll();

    Optional<UsersDTO> findByUsername(String username);

    Optional<UsersDTO> findById(Long id);

    void save(UsersDTO user);

    void saveAll(List<UsersDTO> users);

    void deleteById(Long id);

}
