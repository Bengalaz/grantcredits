package upc.edu.pe.grantcredits.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.grantcredits.domain.model.Company;

public interface Report {
    Page<Report> getAllReports(Pageable pageable);
    Report getReportById(Long reportId);
    Report createReport(Report report);
    Report updateReport(Long reportId, Report reportRequest);
    ResponseEntity<?> deleteReport(Long reportId);
}
