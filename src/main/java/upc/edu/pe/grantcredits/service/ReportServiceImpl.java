package upc.edu.pe.grantcredits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.grantcredits.domain.model.Report;
import upc.edu.pe.grantcredits.domain.repository.ReportRepository;
import upc.edu.pe.grantcredits.domain.service.ReportService;
import upc.edu.pe.grantcredits.exception.ResourceNotFoundException;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Page<Report> getAllReports(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @Override
    public Report getReportById(Long reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Report", "Id", reportId));
    }

    @Override
    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Report updateReport(Long reportId, Report reportRequest) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteReport(Long reportId) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Report", "Id", reportId));
        reportRepository.delete(report);
        return ResponseEntity.ok().build();
    }
}
