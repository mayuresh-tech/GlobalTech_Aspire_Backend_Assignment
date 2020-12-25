package com.globaltech.aspire.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "company_details")
public class Company extends AuditEntity {

    @Id
    @Column(name = "company_id", unique = true)
    private String companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_representative")
    private String companyRepresentative;

    @Column(name = "company_location")
    private String location;

}
