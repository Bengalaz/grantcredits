package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.grantcredits.domain.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {

}
