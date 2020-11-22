package upc.edu.pe.grantcredits.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import upc.edu.pe.grantcredits.domain.model.Company;
import upc.edu.pe.grantcredits.domain.service.CompanyService;
import upc.edu.pe.grantcredits.resource.CompanyResource;
import upc.edu.pe.grantcredits.resource.SaveCompanyResource;

@Tag(name = "Company", description = "Company API")
@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/companies")
    public Page<CompanyResource> getAllCompanies(Pageable pageable){
        Page<Company> companiesPage = companyService.getAllCompanies(pageable);
        List<CompanyResource> resources = companiesPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/companies/{companyId}")
    public CompanyResource getCompanyById(@PathVariable(value = "companyId") Long companyId){
        return convertToResource(companyService.getCompanyById(companyId));
    }

    @PostMapping("/companies")
    public CompanyResource createCompany(
            @Valid @RequestBody SaveCompanyResource resource){
        Company company = convertToEntity(resource);
        return convertToResource(companyService.createCompany(company));
    }

    @PutMapping("/companies/{companyId}")
    public CompanyResource updateCompany(@PathVariable Long companyId,
                                         @Valid @RequestBody SaveCompanyResource resource){
        Company company = convertToEntity(resource);
        return convertToResource(
                companyService.updateCompany(companyId,company));
    }

    @DeleteMapping("/companies/{companyId}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long companyId){return companyService.deleteCompany(companyId);}

    private Company convertToEntity(SaveCompanyResource resource)
    {
        return mapper.map(resource,Company.class);
    }
    private CompanyResource convertToResource(Company entity){
        return mapper.map(entity, CompanyResource.class);
    }
}
