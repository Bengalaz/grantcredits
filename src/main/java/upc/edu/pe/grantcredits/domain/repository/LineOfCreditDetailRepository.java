package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.grantcredits.domain.model.LineOfCreditDetail;

public interface LineOfCreditDetailRepository extends JpaRepository<LineOfCreditDetail,Long> {
}
