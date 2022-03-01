package com.emrekara.work3.app.user.dao;

import com.emrekara.work3.app.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByName(String name);

    Optional<User> findByNameAndTelephoneNumber(String name, String phoneNumber);

    Optional<User> findByEmailOrNameOrTelephoneNumber(String name, String email, String phoneNumber);
}
