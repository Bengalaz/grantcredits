package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.Company;
import upc.edu.pe.grantcredits.domain.repository.CompanyRepository;
import upc.edu.pe.grantcredits.domain.service.CompanyService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Company> getAllCompanies(Pageable pageable)
    {
        return companyRepository.findAll(pageable);
    }

    @Override
    public Company getCompanyById(Long companyId){
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Company", "Id", companyId));

    }

    @Override
    public Company createCompany(Company company) { return companyRepository.save(company); }

    @Override
    public Company updateCompany(Long companyId, Company companyRequest) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Company", "Id", companyId));
        return companyRepository.save(
                company.setUsername(companyRequest.getUsername())
                        .setPassword(companyRequest.getPassword())
                        .setEmail(companyRequest.getEmail())
                        .setPhoneNumber(companyRequest.getPhonenumber()));
    }

    @Override
    public ResponseEntity<?> deleteCompany(Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Company", "Id", companyId));
        companyRepository.delete(company);
        return ResponseEntity.ok().build();
    }
}
