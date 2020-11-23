package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.Customer;
import upc.edu.pe.grantcredits.domain.repository.CompanyRepository;
import upc.edu.pe.grantcredits.domain.repository.CustomerRepository;
import upc.edu.pe.grantcredits.domain.service.CustomerService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable)
    {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getCustomerById(Long customerId){
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer", "Id", customerId));

    }

    @Override
    public Customer createCustomer(Long companyId, Customer customer) {
        return companyRepository.findById(companyId).map(company -> {
            customer.setCompany(company);
            return customerRepository.save(customer);
        }).orElseThrow(() -> new ResourceNotFoundException("Company","Id", companyId));
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customerRequest) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer", "Id", customerId));
        return customerRepository.save(
                customer.setName(customerRequest.getName())
                        .setLastName(customerRequest.getLastName())
                        .setDate_of_birthday(customerRequest.getDate_of_birthday())
                        .setGender(customerRequest.getGender())
                        .setEmail(customerRequest.getEmail())
                        .setDni(customerRequest.getDni()));
    }

    @Override
    public ResponseEntity<?> deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer", "Id", customerId));
        customerRepository.delete(customer);
        return ResponseEntity.ok().build();
    }
}
