package upc.edu.pe.grantcredits.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upc.edu.pe.grantcredits.domain.model.Customer;
import upc.edu.pe.grantcredits.domain.service.CustomerService;
import upc.edu.pe.grantcredits.resource.CustomerResource;
import upc.edu.pe.grantcredits.resource.SaveCustomerResource;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Customer", description = "Customer API")
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/customers")
    public Page<CustomerResource> getAllCustomers(Pageable pageable){
        Page<Customer> customersPage = customerService.getAllCustomers(pageable);
        List<CustomerResource> resources = customersPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/customers/{customerId}")
    public CustomerResource getCustomerById(@PathVariable(value = "customerId") Long customerId){
        return convertToResource(customerService.getCustomerById(customerId));
    }

    @PostMapping("/companies/{companyId}/customers")
    public CustomerResource createCustomer( @PathVariable(value = "companyId") Long companyId,
            @Valid @RequestBody SaveCustomerResource resource){
        Customer customer = convertToEntity(resource);
        return convertToResource(customerService.createCustomer(companyId, customer));
    }

    @PutMapping("/customers/{customerId}")
    public CustomerResource updateCustomer(@PathVariable Long customerId,
                                         @Valid @RequestBody SaveCustomerResource resource){
        Customer customer = convertToEntity(resource);
        return convertToResource(
                customerService.updateCustomer(customerId,customer));
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long customerId){
        return customerService.deleteCustomer(customerId);}

    private Customer convertToEntity(SaveCustomerResource resource)
    {
        return mapper.map(resource,Customer.class);
    }
    private CustomerResource convertToResource(Customer entity){
        return mapper.map(entity, CustomerResource.class);
    }
}
