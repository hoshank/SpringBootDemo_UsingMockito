package com.bl.demo.service;

import com.bl.demo.dto.UserDto;
import com.bl.demo.model.User;

public interface IUserService {
    String loginUser(UserDto user);
    User registerUser(UserDto user);

}
