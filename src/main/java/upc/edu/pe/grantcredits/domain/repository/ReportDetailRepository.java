package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.grantcredits.domain.model.ReportDetail;

public interface ReportDetailRepository extends JpaRepository<ReportDetail,Long> {
}
