package com.poprev.service.user;


import com.poprev.data.model.user.PoprevUser;
import com.poprev.service.dto.CreateUserDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.service.response.UserResponse;

public interface PoprevUserService {
    void registerUser(CreateUserDto dto);
    UserResponse findAllUsers();
    PoprevUser findUserById(Long userId) throws PoprevException;

}
