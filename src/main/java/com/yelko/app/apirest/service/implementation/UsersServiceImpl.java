package com.yelko.app.apirest.service.implementation;

import com.yelko.app.apirest.dto.UserRequest;
import com.yelko.app.apirest.dto.UsersDTO;
import com.yelko.app.apirest.entities.UsersEntity;
import com.yelko.app.apirest.repository.UsersRepository;
import com.yelko.app.apirest.service.UsersService;
import com.yelko.app.apirest.utils.hash.BCrypt;
import com.yelko.app.apirest.utils.helpers.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void save(UserRequest user) {
        UsersEntity users = Helpers.modelMapper().map(user, UsersEntity.class);

        users.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

        this.usersRepository.save(users);
    }

    @Override
    public void saveAll(List<UserRequest> users) {
        List<UsersEntity> us = new ArrayList<>();
        for (UserRequest user : users) {
            UsersEntity usu = Helpers.modelMapper().map(user, UsersEntity.class);
            us.add(usu);
        }
        this.usersRepository.saveAll(us);
    }

    @Override
    public void deleteById(Long id) {
        this.usersRepository.deleteById(id);

    }

    @Override
    public void update(UserRequest request, Long id) {
        Optional<UsersEntity> user = this.usersRepository.findById(id);
        UsersEntity users = user.get();
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setUsername(request.getUsername());

        if (!request.getPassword().isEmpty()){
            users.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }
        this.usersRepository.save(users);

    }

    private UsersDTO convertToUsersDTO(final UsersEntity user){
        return Helpers.modelMapper().map(user, UsersDTO.class);
    }
}