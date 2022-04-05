package com.yelko.app.apirest.repository;

import com.yelko.app.apirest.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Long> {

    @Transactional(readOnly = true)
    Optional<UsersEntity> findByUsername(String username);
}
