package com.globaltech.aspire.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    public UserDTO() {

    }

    public UserDTO(String name, String email, String password, String phoneNo) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    private String userId;

    private String name;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String password;

    private String email;

    private String phoneNo;

}
