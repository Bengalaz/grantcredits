package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.grantcredits.domain.model.Customer;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
