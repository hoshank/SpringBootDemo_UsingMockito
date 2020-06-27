package com.bl.demo.service;

import com.bl.demo.dto.UserDto;
import com.bl.demo.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> loginUser(UserDto user);

    User registerUser(UserDto user);

}
