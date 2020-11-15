package upc.edu.pe.grantcredits.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.grantcredits.domain.model.ReportDetail;

@Repository
public interface ReportDetailRepository extends JpaRepository<ReportDetail,Long> {
}
