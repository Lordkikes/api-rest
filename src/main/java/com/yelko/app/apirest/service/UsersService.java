package com.yelko.app.apirest.service;

import com.yelko.app.apirest.dto.UsersDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersService {

    Page<UsersDTO> findAll();

    UsersDTO findByUsername(String username);

    UsersDTO findById(Long id);

    void save(UsersDTO user);

    void saveAll(List<UsersDTO> users);

    void deleteById(Long id);

}
