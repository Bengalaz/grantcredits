package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.grantcredits.domain.model.Report;

public interface ReportRepository extends JpaRepository<Report,Long> {
}
