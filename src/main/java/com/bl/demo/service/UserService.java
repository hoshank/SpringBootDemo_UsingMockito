package com.bl.demo.service;

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
    public String updateUser(UserDto userDto) {
        Optional<User> user = userRepository.findByUserNameAndPassword(userDto.userName, userDto.password);
        if (user.isPresent())
            return "Login successfull";
        return "invalid details";
    }


}
