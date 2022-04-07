package com.yelko.app.apirest.service.implementation;

import com.yelko.app.apirest.dto.UsersDTO;
import com.yelko.app.apirest.entities.UsersEntity;
import com.yelko.app.apirest.repository.UsersRepository;
import com.yelko.app.apirest.service.UsersService;
import com.yelko.app.apirest.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UsersDTO> findAll() {

        List<UsersDTO> dto = new ArrayList<>();
        Iterable<UsersEntity> users = this.usersRepository.findAll();

        for (UsersEntity user : users) {
            UsersDTO usersDTO = Helpers.modelMapper().map(user, UsersDTO.class);
            dto.add(usersDTO);
        }

        return dto;
    }

    @Override
    public UsersDTO findByUsername(String username) {
        Optional<UsersEntity> user = this.usersRepository.findByUsername(username);
        return user.map(usersEntity -> Helpers.modelMapper().map(usersEntity, UsersDTO.class)).orElse(null);

    }

    @Override
    public UsersDTO findById(Long id) {
        Optional<UsersEntity> user = this.usersRepository.findById(id);
        return user.map(usersEntity -> Helpers.modelMapper().map(usersEntity, UsersDTO.class)).orElse(null);
    }

    @Override
    public void save(UsersDTO user) {
        UsersEntity users = Helpers.modelMapper().map(user, UsersEntity.class);
        this.usersRepository.save(users);
    }

    @Override
    public void saveAll(List<UsersDTO> users) {
        List<UsersEntity> us = new ArrayList<>();
        for (UsersDTO user : users) {
            UsersEntity usu = Helpers.modelMapper().map(user, UsersEntity.class);
            us.add(usu);
        }
        this.usersRepository.saveAll(us);
    }

    @Override
    public void deleteById(Long id) {
        this.usersRepository.deleteById(id);

    }

    private UsersDTO convertToUsersDTO(final UsersEntity user){
        return Helpers.modelMapper().map(user, UsersDTO.class);
    }
}
