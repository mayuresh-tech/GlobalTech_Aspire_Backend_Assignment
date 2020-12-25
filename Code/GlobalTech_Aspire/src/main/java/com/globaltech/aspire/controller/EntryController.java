package com.globaltech.aspire.controller;

import com.globaltech.aspire.dto.ResponseDTO;
import com.globaltech.aspire.dto.UserDTO;
import com.globaltech.aspire.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry")
@Validated
public class EntryController extends BaseController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Signup new User")
    @PostMapping(path = "/signup", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseDTO signupUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam(required = false) String phoneNo) throws Exception {
        UserDTO userDTO = new UserDTO(name, email, password, phoneNo);
        return userService.createUser(userDTO);
    }

    @ApiOperation(value = "Signin User")
    @PostMapping(path = "/signin", produces = { MediaType.APPLICATION_JSON_VALUE })
    public UserDTO signinUser(@RequestParam String email, @RequestParam String password) throws Exception {
        return userService.userAuthenticationByEmail(email, password);
    }
}
