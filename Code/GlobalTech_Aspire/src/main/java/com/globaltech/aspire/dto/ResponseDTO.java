package com.globaltech.aspire.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDTO {

    int status;

    String info;

    String message;

}
