package com.globaltech.aspire.controller;

import com.globaltech.aspire.dto.CompanyDTO;
import com.globaltech.aspire.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    CompanyService companyService;

    @ApiOperation(value = "Create a new Company")
    @PostMapping(path = "/createCompany", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CompanyDTO createNewCompany(@RequestParam String companyName, @RequestParam String companyRepresentative, @RequestParam(required = false) String location) throws Exception {
        CompanyDTO companyDTO = new CompanyDTO(companyName, companyRepresentative, location);
        return companyService.createCompany(companyDTO);
    }

    @ApiOperation(value = "Check Company details")
    @GetMapping(path = "/getCompanyDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
    public CompanyDTO checkCompanyDetails(@RequestParam String companyName) throws Exception {
        return companyService.checkCompany(companyName);
    }

}
