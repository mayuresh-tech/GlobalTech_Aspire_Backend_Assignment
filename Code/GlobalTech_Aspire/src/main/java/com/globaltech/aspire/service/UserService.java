package com.globaltech.aspire.service;

import com.globaltech.aspire.dto.ResponseDTO;
import com.globaltech.aspire.dto.UserDTO;

public interface UserService {

    public ResponseDTO createUser(UserDTO userDTO) throws Exception;

    public UserDTO userAuthenticationByEmail(String email, String password) throws Exception;

}
