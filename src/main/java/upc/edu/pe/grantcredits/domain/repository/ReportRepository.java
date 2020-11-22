package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.grantcredits.domain.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
}
