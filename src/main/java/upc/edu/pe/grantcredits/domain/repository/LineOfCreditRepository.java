package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.grantcredits.domain.model.LineOfCredit;

public interface LineOfCreditRepository extends JpaRepository<LineOfCredit,Long> {
}
