package com.bl.demo.service;
/**
 * purpose:takes the dto object from controller,validates and passes it to repository
 */
import com.bl.demo.dto.UserDto;
import com.bl.demo.model.User;
import com.bl.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public String loginUser(UserDto userDto) {
        Optional<User> user = userRepository.findByUserNameAndPassword(userDto.userName, userDto.password);
        if (user.isPresent())
            return "Login successfull";
        return "invalid details";
    }

    @Override
    public User registerUser(UserDto userDto) {
        User user = new User(userDto);
        return userRepository.save(user);
    }

}
