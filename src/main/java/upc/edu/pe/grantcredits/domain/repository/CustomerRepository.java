package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.grantcredits.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
