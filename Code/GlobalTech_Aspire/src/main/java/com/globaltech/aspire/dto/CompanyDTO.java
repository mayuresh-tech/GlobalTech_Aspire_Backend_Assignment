package com.globaltech.aspire.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {

    public CompanyDTO() {

    }

    public CompanyDTO(String companyName, String companyRepresentative, String location) {
        this.companyName = companyName;
        this.companyRepresentative = companyRepresentative;
        this.location = location;
    }

    private String companyId;

    private String companyName;

    private String companyRepresentative;

    private String location;
}
