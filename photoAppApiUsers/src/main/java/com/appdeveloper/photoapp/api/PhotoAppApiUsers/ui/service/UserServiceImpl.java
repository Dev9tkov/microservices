package com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.service;

import com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.data.UserEntity;
import com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.repository.UserRepository;
import com.appdeveloper.photoapp.api.PhotoAppApiUsers.ui.shared.UserDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
        userEntity.setEncryptedPassword("test");
        userRepository.save(userEntity);
        UserDTO returnValue = modelMapper.map(userEntity, UserDTO.class);
        return returnValue;
    }
}
