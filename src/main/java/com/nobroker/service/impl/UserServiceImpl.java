package com.nobroker.service.impl;

import com.nobroker.entity.User;
import com.nobroker.payload.UserDto;
import com.nobroker.repository.UserRepository;
import com.nobroker.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Long createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    User mapToEntity(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
