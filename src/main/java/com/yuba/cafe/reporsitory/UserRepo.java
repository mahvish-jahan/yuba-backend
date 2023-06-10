package com.yuba.cafe.reporsitory;

import com.yuba.cafe.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);
}
