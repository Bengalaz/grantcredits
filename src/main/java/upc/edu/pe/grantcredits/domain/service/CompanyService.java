package upc.edu.pe.grantcredits.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.grantcredits.domain.model.Company;

public interface CompanyService {
    Page<Company> getAllCompanies(Pageable pageable);
    Company getCompaniesById(Long companyId);
    Company createCompany(Company company);
    Company updateCompany(Long companyId, Company companyRequest);
    ResponseEntity<?> deleteCompany(Long companyId);
}
