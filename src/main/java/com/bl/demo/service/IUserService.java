package com.bl.demo.service;

import com.bl.demo.dto.UserDto;
import com.bl.demo.model.User;

public interface IUserService {
    String updateUser(UserDto user);
    User addUser(UserDto user);

}
