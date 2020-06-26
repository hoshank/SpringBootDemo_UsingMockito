package com.bl.demo.repository;
/**
 * purpose:to perform the crud operation
 */

import com.bl.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUserNameAndPassword(String userName, String password);

}
