package com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.controllers;

import com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.model.CreateUserRequestModel;
import com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.model.CreateUserResponseModel;
import com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.service.UserService;
import com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.shared.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersControllers {
    @Autowired
    UserService userService;

    @Autowired
    private Environment environment;

    @GetMapping("/status/check")
    public String status() {
        return "Working onm port " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);
        UserDTO created = userService.createUser(userDTO);
        CreateUserResponseModel returnValue = modelMapper.map(created, CreateUserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}
