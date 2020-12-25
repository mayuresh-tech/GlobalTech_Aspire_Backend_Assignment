package com.globaltech.aspire.repository;

import com.globaltech.aspire.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    Company findByCompanyName(@NotNull String companyName);

    Company findByCompanyId(String companyId);

    @Query(value = "SELECT c from Company c where " +
        "c.companyName IN (:company_names)")
    List<Company> findCompaniesByName(@Param("company_names") List<String> companyNames);
}
