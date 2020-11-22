package upc.edu.pe.grantcredits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import upc.edu.pe.grantcredits.domain.model.Company;
import upc.edu.pe.grantcredits.domain.service.CompanyService;
import upc.edu.pe.grantcredits.resource.CompanyResource;
import upc.edu.pe.grantcredits.resource.SaveCompanyResource;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/companys")
    public Page<CompanyResource> getAllCompanys(Pageable pageable){

    }

    private Company convertoEntity(SaveCompanyResource resource)
    {
        return mapper.map(resource,Company.class);
    }
    private CompanyResource convertToResource(Company entity){return mapper.map(entity, CompanyResource.class);}
}
