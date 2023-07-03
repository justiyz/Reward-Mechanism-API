package com.poprev.web.controller.user;

import com.poprev.data.model.user.PoprevUser;
import com.poprev.service.dto.CreateUserDto;
import com.poprev.service.exception.PoprevException;
import com.poprev.service.response.UserResponse;
import com.poprev.service.user.PoprevUserServiceImplementation;
import com.poprev.web.response.ResponseDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/users")
public class PoprevUserController {

    @Autowired
    PoprevUserServiceImplementation userServiceImplementation;

    @PostMapping("")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto dto) throws PoprevException {

        userServiceImplementation.registerUser(dto);
        ResponseDetails responseDetails = new ResponseDetails(LocalDateTime.now(), "Project created", "success");
        return new ResponseEntity<>(responseDetails, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllUsers(@RequestParam(required = false) String searchParam) throws PoprevException {
        UserResponse response = userServiceImplementation.findAllUsers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) throws PoprevException {
        PoprevUser user = userServiceImplementation.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
