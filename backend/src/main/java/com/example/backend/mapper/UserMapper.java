package com.example.backend.mapper;

import com.example.backend.dto.UserDTO;
import com.example.backend.security.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserDTO convertUserToUserDRO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User convertUserDTOToUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
