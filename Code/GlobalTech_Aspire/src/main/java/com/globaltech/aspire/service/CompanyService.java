package com.globaltech.aspire.service;

import com.globaltech.aspire.dto.CompanyDTO;
import com.globaltech.aspire.entity.Company;

import java.util.List;

public interface CompanyService {

    public CompanyDTO createCompany(CompanyDTO companyDTO) throws Exception;

    public CompanyDTO checkCompany(String companyName) throws Exception;

    public Company getCompanyDetails(String companyId);

    public List<Company> findByCompanyName(List<String> companyName);

}
