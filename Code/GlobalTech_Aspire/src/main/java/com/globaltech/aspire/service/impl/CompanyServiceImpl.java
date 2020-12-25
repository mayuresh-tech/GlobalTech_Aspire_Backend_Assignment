package com.globaltech.aspire.service.impl;

import com.globaltech.aspire.dto.CompanyDTO;
import com.globaltech.aspire.entity.Company;
import com.globaltech.aspire.repository.CompanyRepository;
import com.globaltech.aspire.service.CompanyService;
import com.globaltech.aspire.util.EntityDTOConverter;
import com.globaltech.aspire.util.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) throws Exception {
        if (companyRepository.findByCompanyName(companyDTO.getCompanyName()) == null) {
            Company company = new Company();
            company.setCompanyId(UUID.randomUUID().toString());
            company.setCompanyName(companyDTO.getCompanyName());
            company.setCompanyRepresentative(companyDTO.getCompanyRepresentative());
            company.setLocation(companyDTO.getLocation());
            company.setCreatedAt(new Date());
            company.setUpdatedAt(new Date());

            companyRepository.save(company);

            companyDTO.setCompanyId(company.getCompanyId());
            return companyDTO;
        } else {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, ErrorMessages.DUPLICATE_COMPANY_NAME);
        }
    }

    @Override
    public CompanyDTO checkCompany(String companyName) {
        if (companyRepository.findByCompanyName(companyName) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ErrorMessages.NO_SUCH_COMPANY);
        } else {
            return EntityDTOConverter.getCompanyDTOFromEntity(companyRepository.findByCompanyName(companyName));
        }
    }

    @Override
    public Company getCompanyDetails(String companyId) {
        return companyRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Company> findByCompanyName(List<String> companyName) {
        return companyRepository.findCompaniesByName(companyName);
    }

}
