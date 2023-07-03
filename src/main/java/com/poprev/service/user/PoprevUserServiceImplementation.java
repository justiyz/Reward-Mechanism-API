package com.poprev.service.user;

import com.poprev.data.model.user.PoprevUser;
import com.poprev.data.model.user.USERTYPE;
import com.poprev.data.repository.user.PoprevUserRepository;
import com.poprev.service.dto.CreateUserDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.service.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoprevUserServiceImplementation implements PoprevUserService{

    @Autowired
    PoprevUserRepository poprevUserRepository;

    @Override
    public void registerUser(CreateUserDto dto) {
        PoprevUser user = PoprevUser.builder()
                .userType(USERTYPE.valueOf(dto.getUserType()))
                .password(encryptPassword(dto.getPassword()))
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();
        poprevUserRepository.save(user);
    }

    @Override
    public UserResponse findAllUsers() {
        List<PoprevUser> users = poprevUserRepository.findAll();
        return UserResponse.builder()
                .totalNumberOfUsers(users.size())
                .users(users)
                .build();
    }

    @Override
    public PoprevUser findUserById(Long userId) throws PoprevException {
        return poprevUserRepository.findById(userId)
                .orElseThrow(()-> new PoprevException("user not found"));
    }

    private String encryptPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
