package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.dto.ResponseDTO;
import com.globaltech.aspire.dto.UserDTO;
import com.globaltech.aspire.entity.User;
import com.globaltech.aspire.repository.UserRepository;
import com.globaltech.aspire.service.UserService;
import com.globaltech.aspire.util.EncryptUtils;
import com.globaltech.aspire.util.EntityDTOConverter;
import com.globaltech.aspire.util.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseDTO createUser(UserDTO userDTO) throws Exception {
        if (userRepository.findByEmail(userDTO.getEmail()) == null) {
            User user = new User();
            user.setUserId(UUID.randomUUID().toString());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(EncryptUtils.encrypt(userDTO.getPassword()));
            user.setPhoneNo(userDTO.getPhoneNo());
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());

            userRepository.save(user);
            return new ResponseDTO(200, user.getUserId(), "User created successfully!");
        }
        else {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, ErrorMessages.DUPLICATE_EMAIL);
        }
    }

    @Override
    public UserDTO userAuthenticationByEmail(String email, String password) throws Exception {
        User user = userRepository.findByEmailAndPassword(email, EncryptUtils.encrypt(password));
        if (user != null) {
            return EntityDTOConverter.getUserDTOFromEntity(user);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, ErrorMessages.INVALID_CREDENTIALS);
        }
    }

}
