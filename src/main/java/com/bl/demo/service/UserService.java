package com.bl.demo.service;
/**
 * purpose:takes the dto object from controller,validates and passes it to repository
 */
import com.bl.demo.dto.UserDto;
import com.bl.demo.exceptions.UserExceptions;
import com.bl.demo.model.User;
import com.bl.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * purpose:to add and register user
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    /**
     *
     * @param userDto input from controller
     * @return string message
     */
    @Override
    public Optional<User> loginUser(UserDto userDto) {
        Optional<User> user = userRepository.findByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
        if (user.isPresent())
            return user;
        throw new UserExceptions("Invalid details");

    }

    /**
     *
     * @param userDto
     * @return returns the object stored
     */

    @Override
    public User registerUser(UserDto userDto) {
        User user = new User(userDto);
        return userRepository.save(user);
    }

}
