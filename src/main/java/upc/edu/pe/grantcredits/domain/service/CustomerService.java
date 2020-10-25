package upc.edu.pe.grantcredits.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.grantcredits.domain.model.Customer;

public interface CustomerService {
    Page<Customer> getAllCustomers(Pageable pageable);
    Customer getCustomerById(Long customerId);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long companyId, Customer customerRequest);
    ResponseEntity<?> deleteCustomer(Long custumerId);
}
